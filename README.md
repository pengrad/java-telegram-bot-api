# java-telegram-bot-api

Simple Java API for [Telegram Bots][1]


Download
-------
Download the latest version via Gradle:
```groovy
compile 'com.github.pengrad:java-telegram-bot-api:1.1.0'
```
or Maven:
```xml
<dependency>
  <groupId>com.github.pengrad</groupId>
  <artifactId>java-telegram-bot-api</artifactId>
  <version>1.1.0</version>
</dependency>
```


Usage
-------
````java
TelegramBot bot = TelegramBotAdapter.build("BOT_TOKEN");

bot.sendMessage(
    123321,    // chat_id
    "Hello!",  // text
    false,     // disable_web_page_preview
    null,      // reply_to_message_id
    new ReplyKeyboardMarkup(new String[]{"BUTTON_OK", "BUTTON_CANCEL"}));  // keyboard
````



 [1]: https://core.telegram.org/bots
