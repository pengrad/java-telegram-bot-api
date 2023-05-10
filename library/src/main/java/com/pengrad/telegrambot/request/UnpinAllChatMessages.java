package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.impl.TelegramBotClient;
import com.pengrad.telegrambot.response.BaseResponse;

/**
 * Stas Parshin
 * 05 November 2020
 */
public class UnpinAllChatMessages extends BaseRequest<UnpinAllChatMessages, BaseResponse> {

    public UnpinAllChatMessages(TelegramBotClient api, Object chatId) {
        super(api, BaseResponse.class);
        add("chat_id", chatId);
    }
}
