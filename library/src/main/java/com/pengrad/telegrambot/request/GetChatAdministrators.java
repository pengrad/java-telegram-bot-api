package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.impl.TelegramBotClient;
import com.pengrad.telegrambot.response.GetChatAdministratorsResponse;

/**
 * Stas Parshin
 * 28 May 2016
 */
public class GetChatAdministrators extends BaseRequest<GetChatAdministrators, GetChatAdministratorsResponse> {

    public GetChatAdministrators(TelegramBotClient api, Object chatId) {
        super(api, GetChatAdministratorsResponse.class);
        add("chat_id", chatId);
    }
}
