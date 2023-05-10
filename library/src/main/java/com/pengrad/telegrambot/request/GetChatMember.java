package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.impl.TelegramBotClient;
import com.pengrad.telegrambot.response.GetChatMemberResponse;

/**
 * Stas Parshin
 * 28 May 2016
 */
public class GetChatMember extends BaseRequest<GetChatMember, GetChatMemberResponse> {

    public GetChatMember(TelegramBotClient api, Object chatId, long userId) {
        super(api, GetChatMemberResponse.class);
        add("chat_id", chatId).add("user_id", userId);
    }
}
