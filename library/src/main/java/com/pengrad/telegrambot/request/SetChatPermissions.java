package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.model.ChatPermissions;
import com.pengrad.telegrambot.response.BaseResponse;

/**
 * Stas Parshin
 * 30 July 2019
 */
public class SetChatPermissions extends BaseRequest<SetChatPermissions, BaseResponse> {

    public SetChatPermissions(Object chatId, ChatPermissions permissions) {
        super(BaseResponse.class);
        add("chat_id", chatId).add("permissions", permissions);
    }
}
