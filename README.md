# java-telegram-bot-api

Simple Java API for [Telegram Bots][1]


Download
-------
Download the latest version via Gradle:
```groovy
compile 'com.github.pengrad:java-telegram-bot-api:1.2.0'
```
or Maven:
```xml
<dependency>
  <groupId>com.github.pengrad</groupId>
  <artifactId>java-telegram-bot-api</artifactId>
  <version>1.2.0</version>
</dependency>
```


Usage
-------
````java
TelegramBot bot = TelegramBotAdapter.build("BOT_TOKEN");

bot.sendMessage(
    123321,                    // chat_id
    "Hello _italic_ *bold*!",  // text
    ParseMode.Markdown,        // Markdown text or null
    false,                     // disable_web_page_preview
    replyMessageId,            // reply_to_message_id
    new ReplyKeyboardMarkup(new String[]{"ok", "test"}).oneTimeKeyboard(true));  // keyboard
````



 [1]: https://core.telegram.org/bots
