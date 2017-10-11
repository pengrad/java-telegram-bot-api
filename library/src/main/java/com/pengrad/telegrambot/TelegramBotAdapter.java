package com.pengrad.telegrambot;

import okhttp3.OkHttpClient;

/**
 * stas
 * 8/4/15.
 */

/**
 * @deprecated Use TelegramBot(botToken) or TelegramBot.Builder
 */
@Deprecated
public class TelegramBotAdapter {

    public static final String API_URL = "https://api.telegram.org/bot";

    public static TelegramBot build(String botToken) {
        return new TelegramBot(botToken);
    }

    public static TelegramBot buildDebug(String botToken) {
        return new TelegramBot.Builder(botToken).debug().build();
    }

    public static TelegramBot buildCustom(String botToken, OkHttpClient okHttpClient) {
        return new TelegramBot.Builder(botToken).okHttpClient(okHttpClient).build();
    }

    public static TelegramBot buildCustom(String botToken, OkHttpClient okHttpClient, String apiUrl) {
        return new TelegramBot.Builder(botToken).okHttpClient(okHttpClient).apiUrl(apiUrl).build();
    }
}
