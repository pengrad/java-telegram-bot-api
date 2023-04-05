package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.response.BaseResponse;

public class ReopenForumTopic extends BaseRequest<ReopenForumTopic, BaseResponse> {

    /**
     * @deprecated use constructor with Long for future compatibility
     */
    @Deprecated
    public ReopenForumTopic(Integer chatId, Integer messageThreadId) {
        this(chatId.toString(), messageThreadId);
    }

    public ReopenForumTopic(Long chatId, Integer messageThreadId) {
        this(chatId.toString(), messageThreadId);
    }

    public ReopenForumTopic(String chatId, Integer messageThreadId) {
        super(BaseResponse.class);
        add("chat_id", chatId);
        add("message_thread_id", messageThreadId);
    }
}