# java-telegram-bot-api

Simple Java API for [Telegram Bots][1]


Download
-------
Download the latest version via Gradle:
```groovy
compile 'com.github.pengrad:java-telegram-bot-api:1.0.1'
```
or Maven:
```xml
<dependency>
  <groupId>com.github.pengrad</groupId>
  <artifactId>java-telegram-bot-api</artifactId>
  <version>1.0.1</version>
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


License
-------

    Copyright 2015 Stas Parshin

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.



 [1]: https://core.telegram.org/bots
