package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.impl.TelegramBotClient;
import com.pengrad.telegrambot.response.GetChatResponse;

/**
 * Stas Parshin
 * 28 May 2016
 */
public class GetChat extends BaseRequest<GetChat, GetChatResponse> {

    public GetChat(TelegramBotClient api, Object chatId) {
        super(api, GetChatResponse.class);
        add("chat_id", chatId);
    }
}
