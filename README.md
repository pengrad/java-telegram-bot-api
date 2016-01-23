## Simple Java API for [Telegram Bots][1]

Full support of all Bot API functions

Download
-------
Download the latest version via Gradle:
```groovy
compile 'com.github.pengrad:java-telegram-bot-api:1.3.2'
```
or Maven:
```xml
<dependency>
  <groupId>com.github.pengrad</groupId>
  <artifactId>java-telegram-bot-api</artifactId>
  <version>1.3.2</version>
</dependency>
```


Usage
-------
#### Create bot
```java
TelegramBot bot = TelegramBotAdapter.build("BOT_TOKEN");
```
**All bot methods have the same signature as original ones.**  
**You can pass `null` as any _Optional_ parameter**

#### Send message
```java
// short syntax
bot.sendMessage(chatId, "short message sending");
bot.sendMessage("@mychannel", "short message sending");

// full
bot.sendMessage(
    chatId,                    // chat_id
    "Hello _italic_ *bold*!",  // text
    ParseMode.Markdown,        // Markdown text or null
    false,                     // disable_web_page_preview
    replyMessageId,            // reply_to_message_id
    new ReplyKeyboardMarkup(new String[]{"ok", "cancel"}).oneTimeKeyboard(true));  // keyboard
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
SendResponse sendResponse = bot.sendMessage(chatId, "short message sending");
Message message = sendResponse.message();
```
#### Send files
3 options to sending files
```java
// as String, resending existing file
String fileId;

// as File
InputFile.photo(file);
InputFile.audio(file);
InputFile.video(file);
InputFile.voice(file);
new InputFile("text/plain", file); 

// as byte[]
InputFileBytes.photo(bytes);
InputFileBytes.audio(bytes);
InputFileBytes.video(bytes);
InputFileBytes.voice(bytes);
new InputFileBytes("text/plain", bytes, "my-file.txt");
```
Examples
```java
// Photo
String fileId = // resending fileId
bot.sendPhoto(chatId, fileId, "caption", null, null);
bot.sendPhoto(chatId, InputFile.photo(imageFile), "caption", replyMessageId, new ForceReply());
bot.sendPhoto(chatId, InputFileBytes.photo(bytes), "caption", null, new ReplyKeyboardHide());

// Same options for all types 
// Audio
bot.sendAudio(chatId, InputFile.audio(audioFile), duration, performer, title, null, null);

// Video
bot.sendVideo(chatId, InputFile.video(videoFile), duration, "caption", null, null);

// Document
bot.sendDocument(chatId, new InputFile("text/plain", docFile), null, null);

// Sticker
bot.sendSticker(chatId, stickerId, null, null);

// Voice
bot.sendVoice(chatId, InputFileBytes.voice(bytes), duration, null, null);
```
#### Send chat action
```java
bot.sendChatAction(chatId, ChatAction.find_location);
bot.sendChatAction(chatId, ChatAction.typing);
bot.sendChatAction(chatId, ChatAction.record_audio);
bot.sendChatAction(chatId, ChatAction.record_video);
bot.sendChatAction("@channel", ChatAction.upload_audio);
bot.sendChatAction("@channel", ChatAction.upload_document);
bot.sendChatAction("@channel", ChatAction.upload_photo);
bot.sendChatAction("@channel", ChatAction.upload_video);
```
#### Get updates 
```java
GetUpdatesResponse updatesResponse = bot.getUpdates(offset, limit, timeout);
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
GetFileResponse getFileResponse = bot.getFile("fileId");
File file = getFileResponse.file(); // com.pengrad.telegrambot.model.File
file.fileId();
file.filePath();  // relative path
file.fileSize();
```
To get downloading link as `https://api.telegram.org/file/bot<token>/<file_path>`
```java
String fullPath = bot.getFullFilePath("fileId");
String fullPath = bot.getFullFilePath(file);  // com.pengrad.telegrambot.model.File
```
#### Inline mode
Getting updates
```java
GetUpdatesResponse updatesResponse = bot.getUpdates(offset, limit, timeout);
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
bot.answerInlineQuery(inlineQuery.id(), r1, r2, r3, r4, r5);
// or full
bot.answerInlineQuery(inlineQuery.id(), new InlineQueryResult[]{r1, r2, r3, r4, r5}, cacheTime, isPersonal, nextOffset);
```


 [1]: https://core.telegram.org/bots
