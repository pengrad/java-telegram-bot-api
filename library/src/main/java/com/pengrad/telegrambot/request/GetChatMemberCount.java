package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.response.GetChatMemberCountResponse;

public class GetChatMemberCount extends BaseRequest<GetChatMemberCount, GetChatMemberCountResponse> {

    public GetChatMemberCount(Object chatId) {
        super(GetChatMemberCountResponse.class);
        add("chat_id", chatId);
    }
}