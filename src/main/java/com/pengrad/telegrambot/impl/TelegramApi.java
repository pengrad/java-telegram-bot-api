package com.pengrad.telegrambot.impl;

import com.google.gson.Gson;
import com.pengrad.telegrambot.request.BaseRequest;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * stas
 * 5/1/16.
 */
public class TelegramApi {

    private final OkHttpClient client;
    private final Gson gson;
    private final String baseUrl;

    public TelegramApi(OkHttpClient client, Gson gson, String baseUrl) {
        this.client = client;
        this.gson = gson;
        this.baseUrl = baseUrl;
    }

    public <T> T send(BaseRequest<T> request) throws IOException {
        Request httpRequest = new Request.Builder()
                .url(baseUrl + request.getMethod())
                .post(request.getRequestBody())
                .build();

        Response response = client.newCall(httpRequest).execute();

        return gson.fromJson(response.body().string(), request.getResponseType());
    }
}
