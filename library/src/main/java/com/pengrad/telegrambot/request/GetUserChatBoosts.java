package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.response.UserChatBoostsResponse;

public class GetUserChatBoosts extends BaseRequest<GetUserChatBoosts, UserChatBoostsResponse> {

    public GetUserChatBoosts(Object chatId, Long userId) {
        super(UserChatBoostsResponse.class);
        add("chat_id", chatId).add("user_id", userId);
    }
}
