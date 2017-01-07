package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.response.GetChatAdministratorsResponse;

/**
 * Stas Parshin
 * 28 May 2016
 */
public class GetChatAdministrators extends BaseRequest<GetChatAdministrators, GetChatAdministratorsResponse> {

    public GetChatAdministrators(Object chatId) {
        super(GetChatAdministratorsResponse.class);
        add("chat_id", chatId);
    }
}
