package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.impl.TelegramBotClient;
import com.pengrad.telegrambot.response.BaseResponse;

/**
 * Stas Parshin
 * 01 July 2017
 */
public class SetChatTitle extends BaseRequest<SetChatTitle, BaseResponse> {

    public SetChatTitle(TelegramBotClient api, Object chatId, String title) {
        super(api, BaseResponse.class);
        add("chat_id", chatId).add("title", title);
    }
}
