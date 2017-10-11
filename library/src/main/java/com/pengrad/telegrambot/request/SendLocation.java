package com.pengrad.telegrambot.request;

/**
 * stas
 * 5/1/16.
 */
public class SendLocation extends AbstractSendRequest<SendLocation> {

    public SendLocation(Object chatId, float latitude, float longitude) {
        super(chatId);
        add("latitude", latitude);
        add("longitude", longitude);
    }

    public SendLocation livePeriod(int livePeriod) {
        return add("live_period", livePeriod);
    }
}
