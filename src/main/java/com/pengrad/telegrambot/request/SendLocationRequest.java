package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.impl.TelegramApi;

/**
 * stas
 * 5/1/16.
 */
public class SendLocationRequest extends AbstractSendRequest<SendLocationRequest> {

    public SendLocationRequest(TelegramApi api, Object chatId, float latitude, float longitude) {
        super(api, chatId);
        add("latitude", latitude);
        add("longitude", longitude);
    }

    @Override
    public String getMethod() {
        return "sendLocation";
    }
}
