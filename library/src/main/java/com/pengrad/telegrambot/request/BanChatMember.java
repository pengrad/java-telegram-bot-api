package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.impl.TelegramBotClient;
import com.pengrad.telegrambot.response.BaseResponse;

public class BanChatMember extends BaseRequest<BanChatMember, BaseResponse> {

    public BanChatMember(TelegramBotClient api, Object chatId, long userId) {
        super(api, BaseResponse.class);
        add("chat_id", chatId).add("user_id", userId);
    }

    public BanChatMember untilDate(int untilDate) {
        return add("until_date", untilDate);
    }

    public BanChatMember revokeMessages(boolean revokeMessages) {
        return add("revoke_messages", revokeMessages);
    }
}