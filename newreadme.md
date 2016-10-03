# Java API for [Telegram Bots](https://core.telegram.org/bots)
[![Build Status](https://travis-ci.org/pengrad/java-telegram-bot-api.svg?branch=master)](https://travis-ci.org/pengrad/java-telegram-bot-api)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.pengrad/java-telegram-bot-api/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.github.pengrad/java-telegram-bot-api)  

Full support of all Bot API 2.1 functions

## Download

Gradle:
```groovy
compile 'com.github.pengrad:java-telegram-bot-api:2.1.2'
```
Maven:
```xml
<dependency>
  <groupId>com.github.pengrad</groupId>
  <artifactId>java-telegram-bot-api</artifactId>
  <version>2.1.2</version>
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
  - [Formatting options](#formatting-options)
- [Updating messages](#updating-messages)
- [Inline mode](#inline-mode)

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
bot.setGetUpdatetsListener(new GetUpdatesListener() {
    @Override
    public int process(List<Update> updates) {

        // process updates

        return GetUpdatesListener.CONFIRMED_UPDATES_ALL;
    }
});
```

Listener should return id of the last processed (confirmed) update.  
To confirm all updates return `GetUpdatesListener.CONFIRMED_UPDATES_ALL`, this should be enough in most cases.  
To not confirm any updates return `GetUpdatesListener.CONFIRMED_UPDATES_NONE`, these updates will be redelivered.  
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

ForceReply, ReplyKeyboardHide
```java
Keyboard forceReply = new ForceReply(isSelective); // or just new ForceReply();
Keyboard replyKeyboardHide = new ReplyKeyboardHide(); // new ReplyKeyboardHide(isSelective)
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

## Updating messages
## Inline mode
