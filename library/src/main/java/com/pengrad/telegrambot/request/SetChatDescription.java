package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.impl.TelegramBotClient;
import com.pengrad.telegrambot.response.BaseResponse;

/**
 * Stas Parshin
 * 01 July 2017
 */
public class SetChatDescription extends BaseRequest<SetChatDescription, BaseResponse> {

    public SetChatDescription(TelegramBotClient api, Object chatId, String description) {
        super(api, BaseResponse.class);
        add("chat_id", chatId).add("description", description);
    }
}
