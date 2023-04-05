package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.response.BaseResponse;

import java.io.File;

/**
 * Stas Parshin
 * 23 July 2017
 */
abstract public class AbstractUploadRequest<T extends BaseRequest<T, R>, R extends BaseResponse> extends BaseRequest<T, R> {

    private final boolean isMultipart;

    public AbstractUploadRequest(Class<? extends R> responseClass, String paramName, Object data) {
        super(responseClass);
        if (data instanceof String) {
            isMultipart = false;
        } else if (data instanceof File) {
            isMultipart = true;
        } else if (data instanceof byte[]) {
            isMultipart = true;
        } else {
            throw new IllegalArgumentException("Sending data should be String, File or byte[]");
        }
        add(paramName, data);
    }

    @Override
    public boolean isMultipart() {
        return isMultipart;
    }
}
