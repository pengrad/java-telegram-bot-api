## Java API for [Telegram Bots][1]

Full support of all Bot API 2.0 functions

Download
-------
Gradle:
```groovy
compile 'com.github.pengrad:java-telegram-bot-api:2.0.0'
```
Maven:
```xml
<dependency>
  <groupId>com.github.pengrad</groupId>
  <artifactId>java-telegram-bot-api</artifactId>
  <version>2.0.0</version>
</dependency>
```
JAR-files:  
https://oss.sonatype.org/content/repositories/releases/com/github/pengrad/java-telegram-bot-api/

Usage
-------
#### Create bot
```java
TelegramBot bot = TelegramBotAdapter.build("BOT_TOKEN");
```
#### Execute methods
```java
// sync
BaseResponse response = bot.execute(request);

// async
bot.execute(request, new Callback() {
    @Override
    public void onResponse(BaseRequest request, BaseResponse response) {
    }
    @Override
    public void onFailure(BaseRequest request, IOException e) {
    }
});
```
**All request methods have the same names as original ones.**  
**Required params should be passed in constructor.**  
**Optional params can be added in chains.**

#### Send message
```java
bot.execute(new SendMessage(chatId, "message text"));

bot.execute(
        new SendMessage(chatId, "message <b>bold</b> text")
                .parseMode(ParseMode.HTML)
                .replyMarkup(new ReplyKeyboardMarkup(new String[]{"button 1", "button 2"}))
);

bot.execute(new SendMessage("@mychannel", "message text"), new Callback<SendMessage, SendResponse>() {
    @Override
    public void onResponse(SendMessage request, SendResponse response) {
    }
    @Override
    public void onFailure(SendMessage request, IOException e) {
    }
});
```
#### Keyboards
```java
Keyboard replyKeyboardMarkup = new ReplyKeyboardMarkup(
                new String[]{"first row button1", "first row button2"},
                new String[]{"second row button1", "second row button2"})
                .oneTimeKeyboard(true)   // optional
                .resizeKeyboard(true)    // optional
                .selective(true);        // optional
                
Keyboard forceReply = new ForceReply(isSelective); // or just new ForceReply();
Keyboard replyKeyboardHide = new ReplyKeyboardHide(); // new ReplyKeyboardHide(isSelective)
```
#### Getting response to sending methods
```java
SendResponse sendResponse = bot.execute(new SendMessage(chatId, "text"));
Message message = sendResponse.message();
```
#### Get updates 
```java
GetUpdatesResponse updatesResponse = bot.execute(new GetUpdates().limit(0).offset(0).timeout(0));
List<Update> updates = updatesResponse.updates();
...
Message message = update.message()
```
If using webhook, you can parse request to Message
```java
Update update = BotUtils.parseUpdate(stringRequest); // from String
Update update = BotUtils.parseUpdate(reader); // from java.io.Reader
Message message = update.message();
```
#### Get file
```java
GetFileResponse getFileResponse = bot.execute(new GetFile("fileId"));
File file = getFileResponse.file(); // com.pengrad.telegrambot.model.File
file.fileId();
file.filePath();  // relative path
file.fileSize();
```
To get downloading link as `https://api.telegram.org/file/bot<token>/<file_path>`
```java
String fullPath = bot.getFullFilePath(file);  // com.pengrad.telegrambot.model.File
```
#### Inline mode
Getting updates
```java
GetUpdatesResponse updatesResponse = bot.execute(new GetUpdates());
List<Update> updates = updatesResponse.updates();
...
InlineQuery inlineQuery = update.inlineQuery();
```
If using webhook, you can parse request to InlineQuery
```java
Update update = BotUtils.parseUpdate(stringRequest); // from String
Update update = BotUtils.parseUpdate(reader); // from java.io.Reader
InlineQuery inlineQuery = update.inlineQuery();
```
Build InlineQueryResult
```java
InlineQueryResult r1 = new InlineQueryResultPhoto("id", "photoUrl", "thumbUrl");
InlineQueryResult r2 = new InlineQueryResultArticle("id", "title", "message text").thumbUrl("url");
InlineQueryResult r3 = new InlineQueryResultGif("id", "gifUrl", "thumbUrl");
InlineQueryResult r4 = new InlineQueryResultMpeg4Gif("id", "mpeg4Url", "thumbUrl");
InlineQueryResult r5 = new InlineQueryResultVideo("id", "videoUrl", InlineQueryResultVideo.MIME_VIDEO_MP4, "message text", "thumbUrl", "video title");
```
Send query
```java
bot.execute(new AnswerInlineQuery(inlineQuery.id(), r1, r2, r3, r4, r5));
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


 [1]: https://core.telegram.org/bots
