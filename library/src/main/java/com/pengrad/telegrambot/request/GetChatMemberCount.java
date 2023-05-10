package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.impl.TelegramBotClient;
import com.pengrad.telegrambot.response.GetChatMemberCountResponse;

public class GetChatMemberCount extends BaseRequest<GetChatMemberCount, GetChatMemberCountResponse> {

    public GetChatMemberCount(TelegramBotClient api, Object chatId) {
        super(api, GetChatMemberCountResponse.class);
        add("chat_id", chatId);
    }
}