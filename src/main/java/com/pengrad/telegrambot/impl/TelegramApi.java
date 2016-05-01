package com.pengrad.telegrambot.impl;

import com.google.gson.Gson;
import com.pengrad.telegrambot.request.BaseRequest;
import okhttp3.*;

import java.io.File;
import java.io.IOException;
import java.util.Map;

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

    public <R> R send(BaseRequest<?, R> request) throws IOException {
        Request httpRequest = new Request.Builder()
                .url(baseUrl + request.getMethod())
                .post(createRequestBody(request))
                .build();

        Response response = client.newCall(httpRequest).execute();

        return gson.fromJson(response.body().string(), request.getResponseType());
    }

    private <R> RequestBody createRequestBody(BaseRequest<?, R> request) {
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
