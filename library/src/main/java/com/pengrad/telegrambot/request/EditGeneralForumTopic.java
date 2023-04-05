package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.response.BaseResponse;

public class EditGeneralForumTopic extends BaseRequest<EditGeneralForumTopic, BaseResponse> {

    public EditGeneralForumTopic(Long chatId, String name) {
        this(chatId.toString(), name);
    }

    public EditGeneralForumTopic(String chatId, String name) {
        super(BaseResponse.class);
        add("chat_id", chatId);
        add("name", name);
    }

}
