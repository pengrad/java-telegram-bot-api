package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.impl.TelegramBotClient;
import com.pengrad.telegrambot.response.BaseResponse;

public class HideGeneralForumTopic extends BaseRequest<HideGeneralForumTopic, BaseResponse> {

    public HideGeneralForumTopic(TelegramBotClient api, Long chatId) {
        this(api, chatId.toString());
    }

    public HideGeneralForumTopic(TelegramBotClient api, String chatId) {
        super(api, BaseResponse.class);
        add("chat_id", chatId);
    }

}
