package com.pengrad.telegrambot.impl;

import com.google.gson.Gson;
import com.pengrad.telegrambot.Callback;
import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.response.BaseResponse;
import okhttp3.*;

import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * stas
 * 5/1/16.
 */
public class TelegramBotClient {

    private final OkHttpClient client;
    private final Gson gson;
    private final String baseUrl;

    public TelegramBotClient(OkHttpClient client, Gson gson, String baseUrl) {
        this.client = client;
        this.gson = gson;
        this.baseUrl = baseUrl;
    }

    public <T extends BaseRequest, R extends BaseResponse> void send(final T request, final Callback<T, R> callback) {
        client.newCall(createRequest(request)).enqueue(new okhttp3.Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                try {
                    R result = gson.fromJson(response.body().string(), request.getResponseType());
                    callback.onResponse(request, result);
                } catch (IOException e) {
                    callback.onFailure(request, e);
                }
            }

            @Override
            public void onFailure(Call call, IOException e) {
                callback.onFailure(request, e);
            }
        });
    }

    public <T extends BaseRequest, R extends BaseResponse> R send(final BaseRequest<T, R> request) {
        try {
            Response response = client.newCall(createRequest(request)).execute();
            return gson.fromJson(response.body().string(), request.getResponseType());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Request createRequest(BaseRequest request) {
        return new Request.Builder()
                .url(baseUrl + request.getMethod())
                .post(createRequestBody(request))
                .build();
    }

    private RequestBody createRequestBody(BaseRequest<?, ?> request) {
        if (request.isMultipart()) {
            MediaType contentType = MediaType.parse(request.getContentType());

            MultipartBody.Builder builder = new MultipartBody.Builder().setType(MultipartBody.FORM);

            for (Map.Entry<String, Object> parameter : request.getParameters().entrySet()) {
                String name = parameter.getKey();
                Object value = parameter.getValue();
                if (value instanceof byte[]) {
                    builder.addFormDataPart(name, request.getFileName(), RequestBody.create(contentType, (byte[]) value));
                } else if (value instanceof File) {
                    builder.addFormDataPart(name, request.getFileName(), RequestBody.create(contentType, (File) value));
                } else {
                    builder.addFormDataPart(name, String.valueOf(value));
                }
            }

            return builder.build();
        } else {
            FormBody.Builder builder = new FormBody.Builder();
            for (Map.Entry<String, Object> parameter : request.getParameters().entrySet()) {
                builder.add(parameter.getKey(), String.valueOf(parameter.getValue()));
            }
            return builder.build();
        }
    }
}
