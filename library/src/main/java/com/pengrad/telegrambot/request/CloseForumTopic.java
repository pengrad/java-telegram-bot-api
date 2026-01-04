package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.response.BaseResponse;

public class CloseForumTopic extends BaseRequest<CloseForumTopic, BaseResponse> {

    public CloseForumTopic(Long chatId, Long messageThreadId) {
        this(chatId.toString(), messageThreadId);
    }

    public CloseForumTopic(String chatId, Long messageThreadId) {
        super(BaseResponse.class);
        add("chat_id", chatId);
        add("message_thread_id", messageThreadId);
    }
}