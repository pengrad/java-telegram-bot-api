package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.impl.TelegramBotClient;
import com.pengrad.telegrambot.response.BaseResponse;

public class EditGeneralForumTopic extends BaseRequest<EditGeneralForumTopic, BaseResponse> {

    public EditGeneralForumTopic(TelegramBotClient api, Long chatId, String name) {
        this(api, chatId.toString(), name);
    }

    public EditGeneralForumTopic(TelegramBotClient api, String chatId, String name) {
        super(api, BaseResponse.class);
        add("chat_id", chatId);
        add("name", name);
    }

}
