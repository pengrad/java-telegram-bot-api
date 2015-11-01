## Simple Java API for [Telegram Bots][1]

Full support of all Bot API functions

Download
-------
Download the latest version via Gradle:
```groovy
compile 'com.github.pengrad:java-telegram-bot-api:1.2.2'
```
or Maven:
```xml
<dependency>
  <groupId>com.github.pengrad</groupId>
  <artifactId>java-telegram-bot-api</artifactId>
  <version>1.2.2</version>
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

// full
bot.sendMessage(
    chatId,                    // chat_id
    "Hello _italic_ *bold*!",  // text
    ParseMode.Markdown,        // Markdown text or null
    false,                     // disable_web_page_preview
    replyMessageId,            // reply_to_message_id
    new ReplyKeyboardMarkup(new String[]{"ok", "cancel"}).oneTimeKeyboard(true));  // keyboard
```



 [1]: https://core.telegram.org/bots
