package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.response.GetChatMemberResponse;

/**
 * Stas Parshin
 * 28 May 2016
 */
public class GetChatMember extends BaseRequest<GetChatMember, GetChatMemberResponse> {

    public GetChatMember(Object chatId, long userId) {
        super(GetChatMemberResponse.class);
        add("chat_id", chatId).add("user_id", userId);
    }
}
