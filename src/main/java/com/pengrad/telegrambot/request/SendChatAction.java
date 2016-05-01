package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.impl.TelegramApi;
import com.pengrad.telegrambot.response.BaseResponse;

/**
 * stas
 * 5/2/16.
 */
public class SendChatAction extends BaseRequest<SendChatAction, BaseResponse> {

    public SendChatAction(TelegramApi api, Object chatId, String action) {
        super(api, BaseResponse.class);
        add("chat_id", chatId).add("action", action);
    }
}
