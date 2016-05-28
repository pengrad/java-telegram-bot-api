package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.response.GetChatMembersCountResponse;

/**
 * Stas Parshin
 * 28 May 2016
 */
public class GetChatMembersCount extends BaseRequest<GetChatMembersCount, GetChatMembersCountResponse> {

    public GetChatMembersCount(Object chatId) {
        super(GetChatMembersCountResponse.class);
        add("chat_id", chatId);
    }
}
