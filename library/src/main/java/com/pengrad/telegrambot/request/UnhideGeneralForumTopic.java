package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.impl.TelegramBotClient;
import com.pengrad.telegrambot.response.BaseResponse;

public class UnhideGeneralForumTopic extends BaseRequest<UnhideGeneralForumTopic, BaseResponse> {

    public UnhideGeneralForumTopic(TelegramBotClient api, Long chatId) {
        this(api, chatId.toString());
    }

    public UnhideGeneralForumTopic(TelegramBotClient api, String chatId) {
        super(api, BaseResponse.class);
        add("chat_id", chatId);
    }

}
