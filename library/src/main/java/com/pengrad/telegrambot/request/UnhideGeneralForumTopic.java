package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.response.BaseResponse;

public class UnhideGeneralForumTopic extends BaseRequest<UnhideGeneralForumTopic, BaseResponse> {

    public UnhideGeneralForumTopic(Long chatId) {
        super(BaseResponse.class);
        add("chat_id", chatId);
    }

    public UnhideGeneralForumTopic(String chatId) {
        super(BaseResponse.class);
        add("chat_id", chatId);
    }

}
