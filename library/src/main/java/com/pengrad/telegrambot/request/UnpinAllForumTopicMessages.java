package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.response.BaseResponse;

public class UnpinAllForumTopicMessages extends BaseRequest<UnpinAllForumTopicMessages, BaseResponse> {

    public UnpinAllForumTopicMessages(Long chatId, Long messageThreadId) {
        this(chatId.toString(), messageThreadId);
    }

    public UnpinAllForumTopicMessages(String chatId, Long messageThreadId) {
        super(BaseResponse.class);
        add("chat_id", chatId);
        add("message_thread_id", messageThreadId);
    }
}