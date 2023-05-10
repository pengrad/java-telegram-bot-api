package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.impl.TelegramBotClient;
import com.pengrad.telegrambot.response.BaseResponse;

public class ReopenGeneralForumTopic extends BaseRequest<ReopenGeneralForumTopic, BaseResponse> {

    public ReopenGeneralForumTopic(TelegramBotClient api, Long chatId) {
        this(api, chatId.toString());
    }

    public ReopenGeneralForumTopic(TelegramBotClient api, String chatId) {
        super(api, BaseResponse.class);
        add("chat_id", chatId);
    }

}
