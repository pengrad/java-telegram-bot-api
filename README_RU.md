# Java Telegram Bot Api
[![Maven Central](https://img.shields.io/maven-central/v/com.github.pengrad/java-telegram-bot-api.svg)](https://search.maven.org/artifact/com.github.pengrad/java-telegram-bot-api)
[![Build Status](https://travis-ci.com/pengrad/java-telegram-bot-api.svg?branch=master)](https://app.travis-ci.com/github/pengrad/java-telegram-bot-api)
[![codecov](https://codecov.io/gh/pengrad/java-telegram-bot-api/branch/master/graph/badge.svg)](https://codecov.io/gh/pengrad/java-telegram-bot-api)

Java библиотека, созданная для работы с [Telegram Bot API](https://core.telegram.org/bots/api)
- Полная поддержка всех методов BOT API 8.1
- Поддержка Telegram [паспорта](https://core.telegram.org/passport) и дешифровки (Decryption API);
- Поддержка [платежей](https://core.telegram.org/bots/payments);
- [Игровая платформа](https://telegram.org/blog/games).

## Скачать

Gradle:
```groovy
implementation 'com.github.pengrad:java-telegram-bot-api:8.1.0'
```
Maven:
```xml
<dependency>
  <groupId>com.github.pengrad</groupId>
  <artifactId>java-telegram-bot-api</artifactId>
  <version>8.1.0</version>
</dependency>
```
Также JAR со всеми зависимостями можно найти [в релизах](https://github.com/pengrad/java-telegram-bot-api/releases).

## Использование
```java
// Создание бота путем передачи токена, полученного от @BotFather
TelegramBot bot = new TelegramBot("BOT_TOKEN");

// Подписка на обновления
bot.setUpdatesListener(updates -> {

    // Обработка обновлений
    
    // return id of last processed update or confirm them all
    return UpdatesListener.CONFIRMED_UPDATES_ALL;
// Создание Обработчика ошибок
}, e -> {
    if (e.response() != null) {
        // Ошибка из Телеграма
        e.response().errorCode();
        e.response().description();
    } else {
        // Как видно проблема сети
        e.printStackTrace();
    }
});

// Отправка сообщений
long chatId = update.message().chat().id();
SendResponse response = bot.execute(new SendMessage(chatId, "Hello!"));
```

## Документация
- [Создание бота](#создание-бота)
- [Создание ответов](#создание-ответов)
- [Получение обновлений](#получение-обновлений)
- [Доступные типы](#доступные-типы)
- [Доступные методы](#доступные-методы)
- [Обновление сообщений](#обновление-сообщений)
- [Стикеры](#стикеры)
- [Inline-режим](#inline-режим)
- [Платежи](#платежи)
- [Telegram паспорт](#telegram-паспорт)
- [Игры](#игры)

### Создание бота

```java
TelegramBot bot = new TelegramBot("BOT_TOKEN");
```
Сетевые операции основаны на библиотеке [OkHttp](https://github.com/square/okhttp).

Вы можете создать бота с нестандартным OkHttpClient для использования собственных таймаутов и перехватчиков.
```java
TelegramBot bot = new TelegramBot.Builder("BOT_TOKEN").okHttpClient(client).build();
```

### Создание ответов

Синхронно
```java
BaseResponse response = bot.execute(request);
```

Асинхронно
```java
bot.execute(request, new Callback() {
    @Override
    public void onResponse(BaseRequest request, BaseResponse response) {
    
    }
    @Override
    public void onFailure(BaseRequest request, IOException e) {
    
    }
});
```

[Ответ на обновление](https://core.telegram.org/bots/faq#how-can-i-make-requests-in-response-to-updates)
```java
String response = request.toWebhookResponse();
```

### Получение обновлений

Для получения обновлений вы можете:
- вызвать метод **getUpdates**;
- распарсить входящий запрос по **Webhook**;
- установить слушателя для получения обновлений.

Класс Update просто копирует ответ, полученный от Telegram.

```java
class Update {
    Integer updateId();
    Message message();
    Message editedMessage();
    InlineQuery inlineQuery();
    ChosenInlineResult chosenInlineResult();
    CallbackQuery callbackQuery();
}
```

#### Использование метода getUpdates()

Создание запроса
```java
GetUpdates getUpdates = new GetUpdates().limit(100).offset(0).timeout(0);
```
Метод getUpdates возвращает 100 самых ранних необработанных обновлений. Для пометки обновления, как обработанного, используйте параметр смещения при вызове getUpdates следующим образом:
`offset = updateId последнего обработанного обновления + 1`  
Все обновления, updateId которых меньше, чем смещение, будут помечены на сервере как обработанные и больше не будут возвращаться.

Исполнение
```java
// Синхронно
GetUpdatesResponse updatesResponse = bot.execute(getUpdates);
List<Update> updates = updatesResponse.updates();
...
Message message = update.message()


// Асинхронно
bot.execute(getUpdates, new Callback<GetUpdates, GetUpdatesResponse>() {
    @Override
    public void onResponse(GetUpdates request, GetUpdatesResponse response) {
        List<Update> updates = response.updates();
    }
    
    @Override
    public void onFailure(GetUpdates request, IOException e) {
    
    }
});
```

#### Веб хуки

Создание запроса
```java
SetWebhook request = new SetWebhook()
       .url("url")
       .certificate(new byte[]{}) // byte[]
       .certificate(new File("path")); // или File 
```

Исполнение
```java
// Синхронно
BaseResponse response = bot.execute(request);
boolean ok = response.isOk();

// Асинхронно
bot.execute(request, new Callback<SetWebhook, BaseResponse>() {
    @Override
    public void onResponse(SetWebhook request, BaseResponse response) {
    
    }
    @Override
    public void onFailure(SetWebhook request, IOException e) {
        
    }
});
```

Используя веб хук Вы можете распарсить запрос в Update
```java
Update update = BotUtils.parseUpdate(stringRequest); // из String
Update update = BotUtils.parseUpdate(reader); // или из java.io.Reader

Message message = update.message();
``` 

#### Слушатель обновлений

Вы можете установить слушателя для получения входящих обновлений, как при использовании вебхука.

При этом getUpdates будет выполняться в цикле.

```java
bot.setUpdatesListener(new UpdatesListener() {
    @Override
    public int process(List<Update> updates) {

        // обработка обновлений

        return UpdatesListener.CONFIRMED_UPDATES_ALL;
    }
// Создание Обработчика ошибок
}, new ExceptionHandler() {
    @override
    public void onException(TelegramException e)
    {
        if (e.response() != null) {
            // Ошибка из Телеграма
            e.response().errorCode();
            e.response().description();
        } else {
            // Как видно проблема сети
            e            .printStackTrace();
        }
    }
});
```

Слушатель должен возвращать id последнего обработанного (подтвержденного) обновления.

- Для подтверждения обработки всех обновлений используйте `UpdatesListener.CONFIRMED_UPDATES_ALL`, этого будет достаточно в большинстве случаев;
- Для того чтобы не подтверждать обработку обновлений, используйте `UpdatesListener.CONFIRMED_UPDATES_NONE`, эти обновления будут передоставлены;
- Чтобы установить определенное обновление, как последнее обработанное, возвращайте его updateId.

Для прекращения получения обновлений
```java
bot.removeGetUpdatesListener();
```

### Доступные типы

Все типы такие же, как и оригинальные.
Поля типов - методы в нижнем CamelCase.

Типы, используемые в ответах **(Update, Message, User, Document...)**, расположены в пакете `com.pengrad.telegrambot.model`.

Типы, используемые в запросах **(Keyboard, InlineQueryResult, ParseMode, InputMessageContent...)**, расположены в пакете `com.pengrad.telegrambot.model.request`.
При создании пользовательского типа для использования в запросах обязательные параметры должны быть переданы в конструкторе, необязательные параметры могут быть добавлены в цепочках.

#### Клавиатуры

ForceReply, ReplyKeyboardRemove
```java
Keyboard forceReply = new ForceReply(isSelective); // or just new ForceReply();
Keyboard replyKeyboardRemove = new ReplyKeyboardRemove(); // new ReplyKeyboardRemove(isSelective)
```

ReplyKeyboardMarkup
```java
Keyboard replyKeyboardMarkup = new ReplyKeyboardMarkup(
                new String[]{"first row button1", "first row button2"},
                new String[]{"second row button1", "second row button2"})
                .oneTimeKeyboard(true)   // optional
                .resizeKeyboard(true)    // optional
                .selective(true);        // optional
```

KeyboardButton
```java
Keyboard keyboard = new ReplyKeyboardMarkup(
        new KeyboardButton[]{
                new KeyboardButton("text"),
                new KeyboardButton("contact").requestContact(true),
                new KeyboardButton("location").requestLocation(true)
        }
);                
```

InlineKeyboardMarkup
```java
InlineKeyboardMarkup inlineKeyboard = new InlineKeyboardMarkup(
        new InlineKeyboardButton[]{
                new InlineKeyboardButton("url").url("www.google.com"),
                new InlineKeyboardButton("callback_data").callbackData("callback_data"),
                new InlineKeyboardButton("Switch!").switchInlineQuery("switch_inline_query")
        });
```

#### Действия в чате
```java
ChatAction action = ChatAction.typing;
ChatAction action = ChatAction.upload_photo;
ChatAction action = ChatAction.find_location;
```

### Доступные методы

Все методы для запросов имеют такие же имена, как и оригинальные.
Обязательные параметры должны быть переданы в конструкторе.
Необязательные параметры могут быть добавлены в цепочках.

#### Отправка сообщения

Все запросы на отправку **(SendMessage, SendPhoto, SendLocation...)** возвращают объект класса **SendResponse**, который содержит **Message**.
```java
SendMessage request = new SendMessage(chatId, "text")
        .parseMode(ParseMode.HTML)
        .disableWebPagePreview(true)
        .disableNotification(true)
        .replyToMessageId(1)
        .replyMarkup(new ForceReply());

// синхронно
SendResponse sendResponse = bot.execute(request);
boolean ok = sendResponse.isOk();
Message message = sendResponse.message();

// асинхронно
bot.execute(request, new Callback<SendMessage, SendResponse>() {
    @Override
    public void onResponse(SendMessage request, SendResponse response) {
       
    }
    
    @Override
    public void onFailure(SendMessage request, IOException e) {
    
    }
});
```

#### Параметры форматирования
```java
ParseMode parseMode = ParseMode.Markdown;
ParseMode parseMode = ParseMode.HTML;
```

#### Получение файла
```java
GetFile request = new GetFile("fileId")
GetFileResponse getFileResponse = bot.execute(request);

File file = getFileResponse.file(); // com.pengrad.telegrambot.model.File
file.fileId();
file.filePath();  // относительный путь
file.fileSize();
```
Для получения ссылки на скачивание вида: `https://api.telegram.org/file/bot<token>/<file_path>`
```java
String fullPath = bot.getFullFilePath(file);  // com.pengrad.telegrambot.model.File
```

#### Другие запросы

Все запросы возвращают BaseResponse, если не упомянуты здесь
```java
class BaseResponse {
  boolean isOk();
  int errorCode();
  String description();
}
```

Запрос GetMe возвращает GetMeResponse  
```java
class GetMeResponse {
  User user();
}
```

Получение администраторов чата
```java
class GetChatAdministratorsResponse  { 
  List<ChatMember> administrators();
}
```

Получение количества участников в чате
```java
class GetChatMembersCountResponse  { 
  int count();
}
```

Получение участника чата
```java
class GetChatMemberResponse  {
  ChatMember chatMember();
}
```

Получение чата
```java
class GetChatResponse  { 
  Chat chat();
}
```

Получить фото из профиля пользователя
```java
class GetUserProfilePhotosResponse {
  UserProfilePhotos photos();
}
```

Остановить опрос
```java
class PollResponse {
  Poll poll();
}
```

### Обновление сообщений

Обычное сообщение
```java
EditMessageText editMessageText = new EditMessageText(chatId, messageId, "new test")
        .parseMode(ParseMode.HTML)
        .disableWebPagePreview(true)
        .replyMarkup(new ReplyKeyboardRemove());
        
BaseResponse response = bot.execute(editMessageText);        
```

Inline сообщение
```java
EditMessageText editInlineMessageText = new EditMessageText(inlineMessageId, "new text");
BaseResponse response = bot.execute(editInlineMessageText);
```

Удалить сообщение
```java
DeleteMessage deleteMessage = new DeleteMessage(chatId, messageId);
BaseResponse response = bot.execute(deleteMessage);
```

### Стикеры

Отправить стикер
```java
// Файл, массив byte[], строковое (String) fileId существующего стикера или строковый (String) URL
SendSticker sendSticker = new SendSticker(chatId, imageFile);
SendResponse response = bot.execute(sendSticker);
```

Получить набор стикеров
```java
GetStickerSet getStickerSet = new GetStickerSet(stickerSet);
GetStickerSetResponse response = bot.execute(getStickerSet);
StickerSet stickerSet = response.stickerSet();
```

Загрузить файл со стикером
```java
// Файл, массив byte[], строковый (String URL)
UploadStickerFile uploadStickerFile = new UploadStickerFile(chatId, stickerFile);
GetFileResponse response = bot.execute(uploadStickerFile);
```

### Inline режим

Получение обновлений
```java
GetUpdatesResponse updatesResponse = bot.execute(new GetUpdates());
List<Update> updates = updatesResponse.updates();
...
InlineQuery inlineQuery = update.inlineQuery();
ChosenInlineResult chosenInlineResult = update.chosenInlineResult();
CallbackQuery callbackQuery = update.callbackQuery();
```

При использовании веб хука Вы можете распарсить запрос в InlineQuery
```java
Update update = BotUtils.parseUpdate(stringRequest); // из строки (String)
Update update = BotUtils.parseUpdate(reader); // из java.io.Reader

InlineQuery inlineQuery = update.inlineQuery();
```

#### Результат inline query
```java
InlineQueryResult r1 = new InlineQueryResultPhoto("id", "photoUrl", "thumbUrl");
InlineQueryResult r2 = new InlineQueryResultArticle("id", "title", "message text").thumbUrl("url");
InlineQueryResult r3 = new InlineQueryResultGif("id", "gifUrl", "thumbUrl");
InlineQueryResult r4 = new InlineQueryResultMpeg4Gif("id", "mpeg4Url", "thumbUrl");

InlineQueryResult r5 = new InlineQueryResultVideo(
  "id", "videoUrl", InlineQueryResultVideo.MIME_VIDEO_MP4, "message", "thumbUrl", "video title")
    .inputMessageContent(new InputLocationMessageContent(21.03f, 105.83f));
```

#### Ответ на inline query
```java
BaseResponse response = bot.execute(new AnswerInlineQuery(inlineQuery.id(), r1, r2, r3, r4, r5));

// или полностью
bot.execute(
        new AnswerInlineQuery(inlineQuery.id(), new InlineQueryResult[]{r1, r2, r3, r4, r5})
                .cacheTime(cacheTime)
                .isPersonal(isPersonal)
                .nextOffset("offset")
                .switchPmParameter("pmParam")
                .switchPmText("pmText")
);
```

### Платежи

Выставить счет
```java
SendInvoice sendInvoice = new SendInvoice(chatId, "title", "desc", "my_payload",
        "providerToken", "my_start_param", "USD", new LabeledPrice("label", 200))
        .needPhoneNumber(true)
        .needShippingAddress(true)
        .isFlexible(true)
        .replyMarkup(new InlineKeyboardMarkup(new InlineKeyboardButton[]{
                new InlineKeyboardButton("just pay").pay(),
                new InlineKeyboardButton("google it").url("www.google.com")
        }));
SendResponse response = bot.execute(sendInvoice);
```

Ответить на запрос о доставке
```java
LabeledPrice[] prices = new LabeledPrice[]{
        new LabeledPrice("delivery", 100),
        new LabeledPrice("tips", 50)
};
AnswerShippingQuery answerShippingQuery = new AnswerShippingQuery(shippingQueryId,
        new ShippingOption("1", "VNPT", prices),
        new ShippingOption("2", "FREE", new LabeledPrice("free delivery", 0))
);
BaseResponse response = bot.execute(answerShippingQuery);

// оповестить об ошибке
AnswerShippingQuery answerShippingError = new AnswerShippingQuery(id, "Can't deliver here!");
BaseResponse response = bot.execute(answerShippingError);
```

Ответить на предварительный запрос
```java
AnswerPreCheckoutQuery answerCheckout = new AnswerPreCheckoutQuery(preCheckoutQueryId);
BaseResponse response = bot.execute(answerPreCheckoutQuery);

// оповестить об ошибке
AnswerPreCheckoutQuery answerCheckout = new AnswerPreCheckoutQuery(id, "Sorry, item not available");
BaseResponse response = bot.execute(answerPreCheckoutQuery);
```

### Telegram паспорт

Когда пользователь подтверждает Ваш запрос путем нажатия на кнопку авторизации (Authorize), API отправляет Update с полем passport_data боту, в котором содержатся зашифрованные данные Telegram Passport. [Мануал по Telegram Passport](https://core.telegram.org/passport#receiving-information)

#### Получение данных
Вы можете получить зашифрованные данные паспорта из обновления (через слушателя обновлений или веб хук)
```java
PassportData passportData = update.message().passportData();
```
PassportData содержит массив из `EncryptedPassportElement` и `EncryptedCredentials`. 
Вам необходимо дешифровать `Credentials` с использованием приватного ключа (публичного ключа, загруженного к `@BotFather`)
```java
String privateKey = "...";
EncryptedCredentials encryptedCredentials = passportData.credentials();
Credentials credentials = encryptedCredentials.decrypt(privateKey);
```
Эти `Credentials` могут быть использованы для дешифровки зашифрованных данных в `EncryptedPassportElement`.
```java
EncryptedPassportElement[] encryptedPassportElements = passportData.data();
for (EncryptedPassportElement element : encryptedPassportElements) {
    DecryptedData decryptedData = element.decryptData(credentials);
    // DecryptedData может быть преобразована в определенный тип с использованием проверки instanceOf 
    if (decryptedData instanceof PersonalDetails) {
        PersonalDetails personalDetails = (PersonalDetails) decryptedData;
    }
    // Или путем проверки типа элемента паспорта
    if (element.type() == EncryptedPassportElement.Type.address) {
        ResidentialAddress address = (ResidentialAddress) decryptedData;
    }
}
```
`EncryptedPassportElement` также содержит массив из `PassportFile` (файлы, загруженные в Telegram Passport).  
Для дешифровки их необходимо скачать один за другим.
Данная библиотека поддерживает загрузку и дешифровку, возвращая расшифрованный массив байт (byte[]).
```java
EncryptedPassportElement element = ...

// Группировка всех файлов
List<PassportFile> files = new ArrayList<PassportFile>();
files.add(element.frontSide());
files.add(element.reverseSide());
files.add(element.selfie());
if (element.files() != null) {
    files.addAll(Arrays.asList(element.files()));
}
if (element.translation() != null) {
    files.addAll(Arrays.asList(element.translation()));
}

// Расшифровка
for (PassportFile file : files) {
    if (file == null) continue;
    byte[] data = element.decryptFile(file, credentials, bot); // GetFile request and decrypt content
    // сохранение в файл при необходимости
    new FileOutputStream("files/" + element.type()).write(data);
}
```

#### Установка ошибок данных паспорта
``` java
SetPassportDataErrors setPassportDataErrors = new SetPassportDataErrors(chatId,
        new PassportElementErrorDataField("personal_details", "first_name", "dataHash",
                "Please enter a valid First name"),
        new PassportElementErrorSelfie("driver_license", "fileHash",
                "Can't see your face on photo")
);
bot.execute(setPassportDataErrors);
```

### Игры

Отправка игры
```java
SendResponse response = bot.execute(new SendGame(chatId, "my_super_game"));
```

Установка счета в игре
```java
BaseResponse response = bot.execute(new SetGameScore(userId, score, chatId, messageId));
```

Получение списка лучших результатов
```java
GetGameHighScoresResponse response = bot.execute(new GetGameHighScores(userId, chatId, messageId));
GameHighScore[] scores = response.result();
```
