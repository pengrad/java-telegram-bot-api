package com.pengrad.telegrambot;

import com.google.gson.Gson;
import com.pengrad.telegrambot.impl.FileApi;
import com.pengrad.telegrambot.impl.TelegramBotClient;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * stas
 * 8/4/15.
 */
public class TelegramBotAdapter {

    public static final String API_URL = "https://api.telegram.org/bot";

    public static TelegramBot build(String botToken) {
        FileApi fileApi = new FileApi(botToken);
        TelegramBotClient api = new TelegramBotClient(client(null), gson(), apiUrl(botToken));
        return new TelegramBot(api, fileApi);
    }

    public static TelegramBot buildDebug(String botToken) {
        FileApi fileApi = new FileApi(botToken);
        TelegramBotClient api = new TelegramBotClient(client(httpLoggingInterceptor()), gson(), apiUrl(botToken));
        return new TelegramBot(api, fileApi);
    }

    private static OkHttpClient client(Interceptor interceptor) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        if (interceptor != null) builder.addInterceptor(interceptor);
        return builder.build();
    }

    private static Interceptor httpLoggingInterceptor() {
        return new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
    }

    private static Gson gson() {
        return new Gson();
    }

    private static String apiUrl(String botToken) {
        return API_URL + botToken + "/";
    }
}
