package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.impl.TelegramBotClient;
import com.pengrad.telegrambot.response.BaseResponse;

/**
 * Stas Parshin
 * 01 January 2020
 */
public class SetChatAdministratorCustomTitle extends BaseRequest<SetChatAdministratorCustomTitle, BaseResponse> {

    public SetChatAdministratorCustomTitle(TelegramBotClient api, Object chatId, long userId, String customTitle) {
        super(api, BaseResponse.class);
        add("chat_id", chatId).add("user_id", userId).add("custom_title", customTitle);
    }
}
