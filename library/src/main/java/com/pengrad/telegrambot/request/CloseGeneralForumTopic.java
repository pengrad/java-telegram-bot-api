package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.impl.TelegramBotClient;
import com.pengrad.telegrambot.response.BaseResponse;

public class CloseGeneralForumTopic extends BaseRequest<CloseGeneralForumTopic, BaseResponse> {

    public CloseGeneralForumTopic(TelegramBotClient api, Long chatId) {
        this(api, chatId.toString());
    }

    public CloseGeneralForumTopic(TelegramBotClient api, String chatId) {
        super(api, BaseResponse.class);
        add("chat_id", chatId);
    }
}
