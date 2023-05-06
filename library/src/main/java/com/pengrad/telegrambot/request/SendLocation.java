package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.impl.TelegramBotClient;

/**
 * stas
 * 5/1/16.
 */
public class SendLocation extends AbstractSendRequest<SendLocation> {

    public SendLocation(TelegramBotClient api, Object chatId, float latitude, float longitude) {
        super(api, chatId);
        add("latitude", latitude);
        add("longitude", longitude);
    }

    public SendLocation horizontalAccuracy(float horizontalAccuracy) {
        return add("horizontal_accuracy", horizontalAccuracy);
    }

    public SendLocation livePeriod(int livePeriod) {
        return add("live_period", livePeriod);
    }

    public SendLocation heading(int heading) {
        return add("heading", heading);
    }

    public SendLocation proximityAlertRadius(int proximityAlertRadius) {
        return add("proximity_alert_radius", proximityAlertRadius);
    }
}
