package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.response.BaseResponse;

public class CloseForumTopic extends BaseRequest<CloseForumTopic, BaseResponse> {

    /**
     * @deprecated use constructor with Long for future compatibility
     */
    @Deprecated
    public CloseForumTopic(Integer chatId, Integer messageThreadId) {
        this(chatId.toString(), messageThreadId);
    }

    public CloseForumTopic(Long chatId, Integer messageThreadId) {
        this(chatId.toString(), messageThreadId);
    }

    public CloseForumTopic(String chatId, Integer messageThreadId) {
        super(BaseResponse.class);
        add("chat_id", chatId);
        add("message_thread_id", messageThreadId);
    }
}