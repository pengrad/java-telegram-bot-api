package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.response.GetChatMembersCountResponse;

/**
 * Stas Parshin
 * 28 May 2016
 * 
 * @deprecated from BOT API v5.3 you should use getChatMemberCount instead
 */

@Deprecated
public class GetChatMembersCount extends BaseRequest<GetChatMembersCount, GetChatMembersCountResponse> {

    public GetChatMembersCount(Object chatId) {
        super(GetChatMembersCountResponse.class);
        add("chat_id", chatId);
    }
}
