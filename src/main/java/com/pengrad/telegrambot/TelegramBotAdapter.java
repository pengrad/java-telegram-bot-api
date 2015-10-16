package com.pengrad.telegrambot;

import com.pengrad.telegrambot.impl.BotApi;
import com.pengrad.telegrambot.impl.FileApi;

import retrofit.RestAdapter;

/**
 * stas
 * 8/4/15.
 */
public class TelegramBotAdapter {

    public static final String API_URL = "https://api.telegram.org/bot";

    public static TelegramBot build(String botToken) {
        RestAdapter restAdapter = prepare(botToken).build();
        BotApi botApi = restAdapter.create(BotApi.class);
        FileApi fileApi = new FileApi(botToken);
        return new TelegramBot(botApi, fileApi);
    }

    public static TelegramBot buildDebug(String botToken) {
        RestAdapter restAdapter = prepare(botToken)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();
        BotApi botApi = restAdapter.create(BotApi.class);
        FileApi fileApi = new FileApi(botToken);
        return new TelegramBot(botApi, fileApi);
    }

    public static RestAdapter.Builder prepare(String botToken) {
        return new RestAdapter.Builder()
                .setEndpoint(API_URL + botToken);
    }
}
