package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.impl.TelegramApi;
import com.pengrad.telegrambot.response.OkResponse;

/**
 * stas
 * 5/2/16.
 */
public class SendChatActionRequest extends BaseRequest<SendChatActionRequest, OkResponse> {

    public SendChatActionRequest(TelegramApi api, Object chatId, String action) {
        super(api, OkResponse.class);
        add("chat_id", chatId).add("action", action);
    }

    @Override
    public String getMethod() {
        return "sendChatAction";
    }
}
