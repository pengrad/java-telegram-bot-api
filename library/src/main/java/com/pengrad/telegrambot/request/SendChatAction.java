package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.impl.TelegramBotClient;
import com.pengrad.telegrambot.model.request.ChatAction;
import com.pengrad.telegrambot.response.BaseResponse;

/**
 * stas
 * 5/2/16.
 */
public class SendChatAction extends BaseRequest<SendChatAction, BaseResponse> {

    public SendChatAction(TelegramBotClient api, Object chatId, String action) {
        super(api, BaseResponse.class);
        add("chat_id", chatId).add("action", action);
    }

    public SendChatAction(TelegramBotClient api, Object chatId, ChatAction action) {
        super(api, BaseResponse.class);
        add("chat_id", chatId).add("action", action.name());
    }

    public SendChatAction messageThreadId(int message_thread_id) {
        add("message_thread_id", message_thread_id);
        return this;
    }
}
