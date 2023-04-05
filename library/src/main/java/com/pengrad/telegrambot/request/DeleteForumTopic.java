package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.response.BaseResponse;

public class DeleteForumTopic extends BaseRequest<DeleteForumTopic, BaseResponse> {

    /**
     * @deprecated use constructor with Long for future compatibility
     */
    @Deprecated
    public DeleteForumTopic(Integer chatId, Integer messageThreadId) {
        this(chatId.toString(), messageThreadId);
    }

    public DeleteForumTopic(Long chatId, Integer messageThreadId) {
        this(chatId.toString(), messageThreadId);
    }

    public DeleteForumTopic(String chatId, Integer messageThreadId) {
        super(BaseResponse.class);
        add("chat_id", chatId);
        add("message_thread_id", messageThreadId);
    }
}