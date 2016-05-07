package com.pengrad.telegrambot.request;

import java.io.File;

/**
 * stas
 * 5/1/16.
 */
abstract public class AbstractMultipartRequest<T extends AbstractMultipartRequest> extends AbstractSendRequest<T> {

    private final boolean isMultipart;

    public AbstractMultipartRequest(Object chatId, Object file) {
        super(chatId);
        if (file instanceof String) {
            isMultipart = false;
        } else if (file instanceof File || file instanceof byte[]) {
            isMultipart = true;
        } else {
            throw new IllegalArgumentException("Sending data should be String, File or byte[]");
        }
        add(getFileParamName(), file);
    }

    @Override
    public boolean isMultipart() {
        return isMultipart;
    }

    abstract protected String getFileParamName();

    @Override
    abstract public String getFileName();

    @Override
    abstract public String getContentType();
}
