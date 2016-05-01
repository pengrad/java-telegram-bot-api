package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.impl.TelegramApi;

/**
 * stas
 * 5/1/16.
 */
public class SendLocation extends AbstractSendRequest<SendLocation> {

    public SendLocation(TelegramApi api, Object chatId, float latitude, float longitude) {
        super(api, chatId);
        add("latitude", latitude);
        add("longitude", longitude);
    }
}
