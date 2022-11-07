package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.response.BaseResponse;

public class ReopenForumTopic extends BaseRequest<ReopenForumTopic, BaseResponse> {
    public ReopenForumTopic(Integer chatId, Integer messageThreadId) {
        super(BaseResponse.class);
        add("chat_id", chatId);
        add("message_thread_id", messageThreadId);
    }

    public ReopenForumTopic(String chatId, Integer messageThreadId) {
        super(BaseResponse.class);
        add("chat_id", chatId);
        add("message_thread_id", messageThreadId);
    }
}