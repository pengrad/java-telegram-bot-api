# Java API for [Telegram Bots and Gaming Platform](https://core.telegram.org/bots)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.pengrad/java-telegram-bot-api/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.github.pengrad/java-telegram-bot-api)
[![Build Status](https://travis-ci.org/pengrad/java-telegram-bot-api.svg?branch=master)](https://travis-ci.org/pengrad/java-telegram-bot-api)
[![codecov](https://codecov.io/gh/pengrad/java-telegram-bot-api/branch/master/graph/badge.svg)](https://codecov.io/gh/pengrad/java-telegram-bot-api)  

Full support of all Bot API 3.0 methods with Payment and Gaming Platform

## Download

Gradle:
```groovy
compile 'com.github.pengrad:java-telegram-bot-api:3.0.1'
```
Maven:
```xml
<dependency>
  <groupId>com.github.pengrad</groupId>
  <artifactId>java-telegram-bot-api</artifactId>
  <version>3.0.1</version>
</dependency>
```
JAR-files:  
https://oss.sonatype.org/content/repositories/releases/com/github/pengrad/java-telegram-bot-api/

## Contents

- [Creating your bot](#creating-your-bot)
- [Making requests](#making-requests)
- [Getting updates](#getting-updates)
  - [Get Updates](#get-updates)
  - [Webhook](#webhook)
  - [Updates Listener](#updates-listener)
- [Available types](#available-types)
  - [Keyboards](#keyboards)
  - [Chat Action](#chat-action)  
- [Available methods](#available-methods)
  - [Send message](#send-message)
  - [Formatting options](#formatting-options)
  - [Get file](#get-file)
  - [Other requests](#other-requests)
- [Updating messages](#updating-messages)
- [Inline mode](#inline-mode)
  - [Inline query result](#inline-query-result)
  - [Answer inline query](#answer-inline-query)
- [Payments](#payments)  
- [Games](#games)
- [Test Telegram Bot API](#test-telegram-bot-api)

## Creating your bot

```java
TelegramBot bot = TelegramBotAdapter.build("BOT_TOKEN");
```
Network operations based on OkHttp library.  
You can build bot with custom OkHttpClient, for specific timeouts or interceptors.
```java
TelegramBot bot = TelegramBotAdapter.buildCustom("BOT_TOKEN", okHttpClient);
```

## Making requests

Synchronous
```java
BaseResponse response = bot.execute(request);
```

Asynchronous
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

## Getting updates

You can use **getUpdates** request, parse incoming **Webhook** request, or set listener to receive updates.  
Update object just copies Telegram's response.

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

### Get updates

Building request
```java
GetUpdates getUpdates = new GetUpdates().limit(100).offset(0).timeout(0);
```

The getUpdates method returns the earliest 100 unconfirmed updates. To confirm an update, use the offset parameter when calling getUpdates like this:
`offset = updateId of last processed update + 1`  
All updates with updateId less than offset will be marked as confirmed on the server and will no longer be returned.

Executing
```java
// sync
GetUpdatesResponse updatesResponse = bot.execute(getUpdates);
List<Update> updates = updatesResponse.updates();
...
Message message = update.message()


// async
bot.execute(getUpdates, new Callback<GetUpdates, GetUpdatesResponse>() {
    @Override
    public void onResponse(GetUpdates request, GetUpdatesResponse response) {
        List<Update> updates = updatesResponse.updates();
    }
    
    @Override
    public void onFailure(GetUpdates request, IOException e) {
    
    }
});
```

### Webhook

Building request
```java
SetWebhook request = new SetWebhook()
       .url("url")
       .certificate(new byte[]{}) // byte[]
       .certificate(new File("path")); // or file 
```

Executing
```java
// sync
BaseResponse response = bot.execute(request);
boolean ok = response.isOk();

// async
bot.execute(request, new Callback<SetWebhook, BaseResponse>() {
    @Override
    public void onResponse(SetWebhook request, BaseResponse response) {
    
    }
    @Override
    public void onFailure(SetWebhook request, IOException e) {
        
    }
});
```

Using Webhook you can parse request to Update
```java
Update update = BotUtils.parseUpdate(stringRequest); // from String
Update update = BotUtils.parseUpdate(reader); // or from java.io.Reader

Message message = update.message();
``` 

### Updates Listener

You can set listener to receiving incoming updates as if using Webhook.  
This will trigger executing getUpdates requests in a loop.

```java
bot.setUpdatesListener(new UpdatesListener() {
    @Override
    public int process(List<Update> updates) {

        // process updates

        return UpdatesListener.CONFIRMED_UPDATES_ALL;
    }
});
```

Listener should return id of the last processed (confirmed) update.  
To confirm all updates return `UpdatesListener.CONFIRMED_UPDATES_ALL`, this should be enough in most cases.  
To not confirm any updates return `UpdatesListener.CONFIRMED_UPDATES_NONE`, these updates will be redelivered.  
To set specific update as last confirmed just return required updateId.

To stop receiving updates
```java
bot.removeGetUpdatesListener();
```

## Available types

All types have the same name as original ones.  
Type's fields are methods in lowerCamelCase.

Types used in responses **(Update, Message, User, Document...)** are in `com.pengrad.telegrambot.model` package. 

Types used in requests **(Keyboard, InlineQueryResult, ParseMode, InputMessageContent...)** are in `com.pengrad.telegrambot.model.request` package.  
When creating request's type required params should be passed in constructor, optional params can be added in chains.

### Keyboards

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
                new InlineKeyboardButton("url").url("url"),
                new InlineKeyboardButton("callback_data").callbackData("callback_data"),
                new InlineKeyboardButton("switch_inline_query").switchInlineQuery("switch_inline_query")
        });
```

### Chat Action
```java
ChatAction action = ChatAction.typing;
ChatAction action = ChatAction.upload_photo;
ChatAction action = ChatAction.find_location;
```

## Available methods

All request methods have the same names as original ones.  
Required params should be passed in constructor.  
Optional params can be added in chains.

### Send message 

All send requests **(SendMessage, SendPhoto, SendLocation...)** return **SendResponse** object that contains **Message**.
```java
SendMessage request = new SendMessage(chatId, "text")
        .parseMode(ParseMode.HTML)
        .disableWebPagePreview(true)
        .disableNotification(true)
        .replyToMessageId(1)
        .replyMarkup(new ForceReply());

// sync
SendResponse sendResponse = bot.execute(request);
boolean ok = sendResponse.isOk();
Message message = sendResponse.message();

// async
bot.execute(request, new Callback<SendMessage, SendResponse>() {
    @Override
    public void onResponse(SendMessage request, SendResponse response) {
       
    }
    
    @Override
    public void onFailure(SendMessage request, IOException e) {
    
    }
});
```

### Formatting options
```java
ParseMode parseMode = ParseMode.Markdown;
ParseMode parseMode = ParseMode.HTML;
```

### Get file
```java
GetFile request = new GetFile("fileId")
GetFileResponse getFileResponse = bot.execute(request);

File file = getFileResponse.file(); // com.pengrad.telegrambot.model.File
file.fileId();
file.filePath();  // relative path
file.fileSize();
```
To get downloading link as `https://api.telegram.org/file/bot<token>/<file_path>`
```java
String fullPath = bot.getFullFilePath(file);  // com.pengrad.telegrambot.model.File
```

### Other requests

All requests return BaseResponse if not mention here
```java
class BaseResponse {
  boolean isOk();
  int errorCode();
  String description();
}
```

GetMe request returns GetMeResponse  
```java
class GetMeResponse {
  User user();
}
```

GetChatAdministrators
```java
class GetChatAdministratorsResponse  { 
  List<ChatMember> administrators() 
}
```

GetChatMembersCount
```java
class GetChatMembersCountResponse  { 
  ChatMember chatMember() 
}
```

GetChatMember
```java
class GetChatMemberResponse  {
  int count() 
}
```

GetChat
```java
class GetChatResponse  { 
  Chat chat() 
}
```

GetUserProfilePhotos
```java
class GetUserProfilePhotosResponse {
  UserProfilePhotos photos()
}
```

## Updating messages

Normal message
```java
EditMessageText editMessageText = new EditMessageText(chatId, messageId, "new test")
        .parseMode(ParseMode.HTML)
        .disableWebPagePreview(true)
        .replyMarkup(new ReplyKeyboardRemove());
        
BaseResponse response = bot.execute(editMessageText);        
```

Inline message
```java
EditMessageText editInlineMessageText = new EditMessageText(inlineMessageId, "new text");
BaseResponse response = bot.execute(editInlineMessageText);
```

Delete message
```java
DeleteMessage deleteMessage = new DeleteMessage(chatId, messageId);
BaseResponse response = bot.execute(deleteMessage);
```

## Inline mode

Getting updates
```java
GetUpdatesResponse updatesResponse = bot.execute(new GetUpdates());
List<Update> updates = updatesResponse.updates();
...
InlineQuery inlineQuery = update.inlineQuery();
ChosenInlineResult chosenInlineResult = update.chosenInlineResult();
CallbackQuery callbackQuery = update.callbackQuery();
```

If using webhook, you can parse request to InlineQuery
```java
Update update = BotUtils.parseUpdate(stringRequest); // from String
Update update = BotUtils.parseUpdate(reader); // from java.io.Reader

InlineQuery inlineQuery = update.inlineQuery();
```

### Inline query result
```java
InlineQueryResult r1 = new InlineQueryResultPhoto("id", "photoUrl", "thumbUrl");
InlineQueryResult r2 = new InlineQueryResultArticle("id", "title", "message text").thumbUrl("url");
InlineQueryResult r3 = new InlineQueryResultGif("id", "gifUrl", "thumbUrl");
InlineQueryResult r4 = new InlineQueryResultMpeg4Gif("id", "mpeg4Url", "thumbUrl");

InlineQueryResult r5 = new InlineQueryResultVideo(
  "id", "videoUrl", InlineQueryResultVideo.MIME_VIDEO_MP4, "message", "thumbUrl", "video title")
    .inputMessageContent(new InputLocationMessageContent(21.03f, 105.83f));
```

### Answer inline query
```java
BaseResponse response = bot.execute(new AnswerInlineQuery(inlineQuery.id(), r1, r2, r3, r4, r5));

// or full
bot.execute(
        new AnswerInlineQuery(inlineQuery.id(), new InlineQueryResult[]{r1, r2, r3, r4, r5})
                .cacheTime(cacheTime)
                .isPersonal(isPersonal)
                .nextOffset("offset")
                .switchPmParameter("pmParam")
                .switchPmText("pmText")
);
```

### Payments

Send invoice
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

Answer shipping query
```java
AnswerShippingQuery answerShippingQuery = new AnswerShippingQuery(shippingQueryId,
        new ShippingOption("1", "VNPT", new LabeledPrice("delivery", 100), new LabeledPrice("tips", 50)),
        new ShippingOption("2", "FREE", new LabeledPrice("free delivery", 0))
);
BaseResponse response = bot.execute(answerShippingQuery);

// answer with error
AnswerShippingQuery answerShippingError = new AnswerShippingQuery(shippingQueryId, "Can't delivery to your address");
BaseResponse response = bot.execute(answerShippingError);
```

Answer pre-checkout query
```java
AnswerPreCheckoutQuery answerCheckout = new AnswerPreCheckoutQuery(preCheckoutQueryId);
BaseResponse response = bot.execute(answerPreCheckoutQuery);

// answer with error
AnswerPreCheckoutQuery answerCheckout = new AnswerPreCheckoutQuery(preCheckoutQueryId, "Sorry, item not available");
BaseResponse response = bot.execute(answerPreCheckoutQuery);
```

### Games

Send game
```java
SendResponse response = bot.execute(new SendGame(chatId, "my_super_game"));
```

Set game score
```java
BaseResponse response = bot.execute(new SetGameScore(userId, score, chatId, messageId));
```

Get game high scores
```java
GetGameHighScoresResponse response = bot.execute(new GetGameHighScores(userId, chatId, messageId));
GameHighScore[] scores = response.result();
```

### Test Telegram Bot API
Test on [RapidAPI](https://rapidapi.com/package/TelegramBot/functions?utm_source=TelegramGitHub&utm_medium=button)
