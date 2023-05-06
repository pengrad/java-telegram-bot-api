package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.impl.TelegramBotClient;
import com.pengrad.telegrambot.model.ChatPermissions;
import com.pengrad.telegrambot.response.BaseResponse;

/**
 * Stas Parshin
 * 01 July 2017
 */
public class RestrictChatMember extends BaseRequest<RestrictChatMember, BaseResponse> {

    public RestrictChatMember(TelegramBotClient api, Object chatId, long userId, ChatPermissions permissions) {
        super(api, BaseResponse.class);
        add("chat_id", chatId).add("user_id", userId).add("permissions", permissions);
    }

    public RestrictChatMember untilDate(int untilDate) {
        return add("until_date", untilDate);
    }

    public RestrictChatMember useIndependentChatPermissions(boolean useIndependentChatPermissions) {
        return add("use_independent_chat_permissions", useIndependentChatPermissions);
    }
}
