package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.impl.TelegramApi;
import okhttp3.RequestBody;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * stas
 * 5/1/16.
 */
public abstract class BaseRequest<T> {

    private final TelegramApi api;
    private final Class<T> responseClass;

    public BaseRequest(TelegramApi api, Class<T> responseClass) {
        this.api = api;
        this.responseClass = responseClass;
    }

    abstract public String getMethod();

    public Type getResponseType() {
        return responseClass;
    }

    abstract public RequestBody getRequestBody();

    public T execute() {
        try {
            return api.send(this);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
