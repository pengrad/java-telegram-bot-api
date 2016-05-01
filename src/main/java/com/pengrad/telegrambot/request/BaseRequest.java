package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.impl.TelegramApi;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/**
 * stas
 * 5/1/16.
 */
abstract public class BaseRequest<T extends BaseRequest, R> {

    @SuppressWarnings("unchecked")
    private final T thisAsT = (T) this;

    private final TelegramApi api;
    private final Class<R> responseClass;
    private final Map<String, Object> parameters;

    public BaseRequest(TelegramApi api, Class<R> responseClass) {
        this.api = api;
        this.responseClass = responseClass;
        this.parameters = new HashMap<String, Object>();
    }

    public String getMethod() {
        String className = this.getClass().getSimpleName();
        return Character.toLowerCase(className.charAt(0)) + className.substring(1);
    }

    protected T add(String name, Object val) {
        parameters.put(name, val);
        return thisAsT;
    }

    public Map<String, Object> getParameters() {
        return parameters;
    }

    public Type getResponseType() {
        return responseClass;
    }

    public boolean isMultipart() {
        return false;
    }

    public String getFileName() {
        return "file.txt";
    }

    public String getContentType() {
        return "application/x-www-form-urlencoded";
    }

    public R execute() {
        try {
            return api.send(this);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
