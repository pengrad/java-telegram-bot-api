package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.impl.TelegramBotClient;
import com.pengrad.telegrambot.response.BaseResponse;

public class ReopenForumTopic extends BaseRequest<ReopenForumTopic, BaseResponse> {

    /**
     * @deprecated use constructor with Long for future compatibility
     */
    @Deprecated
    public ReopenForumTopic(TelegramBotClient api, Integer chatId, Integer messageThreadId) {
        this(api, chatId.toString(), messageThreadId);
    }

    public ReopenForumTopic(TelegramBotClient api, Long chatId, Integer messageThreadId) {
        this(api, chatId.toString(), messageThreadId);
    }

    public ReopenForumTopic(TelegramBotClient api, String chatId, Integer messageThreadId) {
        super(api, BaseResponse.class);
        add("chat_id", chatId);
        add("message_thread_id", messageThreadId);
    }
}