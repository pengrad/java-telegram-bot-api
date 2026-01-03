package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.response.BaseResponse;

public class DeleteForumTopic extends BaseRequest<DeleteForumTopic, BaseResponse> {

    public DeleteForumTopic(Long chatId, Long messageThreadId) {
        this(chatId.toString(), messageThreadId);
    }

    public DeleteForumTopic(String chatId, Long messageThreadId) {
        super(BaseResponse.class);
        add("chat_id", chatId);
        add("message_thread_id", messageThreadId);
    }
}