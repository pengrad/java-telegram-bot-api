package com.pengrad.telegrambot;

import retrofit.RestAdapter;

/**
 * stas
 * 8/4/15.
 */
public class TelegramBotAdapter {

    public static final String API_URL = "https://api.telegram.org/bot";

    public static TelegramBot build(String botToken) {
        RestAdapter restAdapter = prepare(botToken).build();
        return restAdapter.create(TelegramBot.class);
    }

    public static TelegramBot buildDebug(String botToken) {
        RestAdapter restAdapter = prepare(botToken)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();
        return restAdapter.create(TelegramBot.class);
    }

    public static RestAdapter.Builder prepare(String botToken) {
        return new RestAdapter.Builder()
                .setEndpoint(API_URL + botToken);
    }
}
