package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.BotUtils;
import com.pengrad.telegrambot.response.BaseResponse;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * stas
 * 5/1/16.
 */
abstract public class BaseRequest<T extends BaseRequest<T, R>, R extends BaseResponse> {

    @SuppressWarnings("unchecked")
    protected final T thisAsT = (T) this;

    private final Class<? extends R> responseClass;
    private final Map<String, Object> parameters;

    public BaseRequest(Class<? extends R> responseClass) {
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
}
