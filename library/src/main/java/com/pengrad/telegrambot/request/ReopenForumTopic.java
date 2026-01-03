package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.response.BaseResponse;

public class ReopenForumTopic extends BaseRequest<ReopenForumTopic, BaseResponse> {

    public ReopenForumTopic(Long chatId, Long messageThreadId) {
        this(chatId.toString(), messageThreadId);
    }

    public ReopenForumTopic(String chatId, Long messageThreadId) {
        super(BaseResponse.class);
        add("chat_id", chatId);
        add("message_thread_id", messageThreadId);
    }
}