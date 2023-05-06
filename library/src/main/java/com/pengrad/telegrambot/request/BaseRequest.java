package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.BotUtils;
import com.pengrad.telegrambot.Callback;
import com.pengrad.telegrambot.impl.TelegramBotClient;
import com.pengrad.telegrambot.response.BaseResponse;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;

/**
 * stas
 * 5/1/16.
 */
abstract public class BaseRequest<T extends BaseRequest<T, R>, R extends BaseResponse> {

    @SuppressWarnings("unchecked")
    protected final T thisAsT = (T) this;
    TelegramBotClient api;
    private final Class<? extends R> responseClass;
    private final Map<String, Object> parameters;

    public BaseRequest(TelegramBotClient api, Class<? extends R> responseClass) {
        this.api = api;
        this.responseClass = responseClass;
        this.parameters = new LinkedHashMap<>();
    }

    protected T add(String name, Object val) {
        parameters.put(name, val);
        return thisAsT;
    }

    protected T addAll(Map<String, Object> values) {
        parameters.putAll(values);
        return thisAsT;
    }

    public String getMethod() {
        String className = this.getClass().getSimpleName();
        return Character.toLowerCase(className.charAt(0)) + className.substring(1);
    }

    public Map<String, Object> getParameters() {
        return parameters;
    }

    public Class<? extends R> getResponseType() {
        return responseClass;
    }

    public boolean isMultipart() {
        return false;
    }

    public String getFileName() {
        return ContentTypes.GENERAL_FILE_NAME;
    }

    public String getContentType() {
        return ContentTypes.GENERAL_MIME_TYPE;
    }

    public int getTimeoutSeconds() {
        return 0;
    }

    public String toWebhookResponse() {
        Map<String, Object> fullMap = new LinkedHashMap<>(parameters);
        fullMap.put("method", getMethod());
        return BotUtils.toJson(fullMap);
    }

    public R execute() {
        return api.send(this);
    }

    public void execute(Callback<T, R> callback) {
        api.send(this.thisAsT, callback);
    }

    public void execute(BiConsumer<T, R> onResponse, BiConsumer<T, IOException> onFailure) {
        Callback<T, R> callback = new Callback<T, R>() {
            @Override
            public void onResponse(T request, R response) {
                onResponse.accept(request, response);
            }

            @Override
            public void onFailure(T request, IOException e) {
                onFailure.accept(request ,e);
            }
        };
        this.execute(callback);
    }
}
