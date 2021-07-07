package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.response.BaseResponse;

/**
 * stas
 * 5/2/16.
 */
public class UnbanChatMember extends BaseRequest<UnbanChatMember, BaseResponse> {

    public UnbanChatMember(Object chatId, long userId) {
        super(BaseResponse.class);
        add("chat_id", chatId).add("user_id", userId);
    }

    public UnbanChatMember onlyIfBanned(boolean onlyIfBanned) {
        return add("only_if_banned", onlyIfBanned);
    }
}
