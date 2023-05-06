package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.impl.TelegramBotClient;
import com.pengrad.telegrambot.response.BaseResponse;

/**
 * Stas Parshin
 * 01 July 2017
 */
public class UnpinChatMessage extends BaseRequest<UnpinChatMessage, BaseResponse> {

    public UnpinChatMessage(TelegramBotClient api, Object chatId) {
        super(api, BaseResponse.class);
        add("chat_id", chatId);
    }

    public UnpinChatMessage messageId(Integer messageId) {
        return add("message_id", messageId);
    }
}
