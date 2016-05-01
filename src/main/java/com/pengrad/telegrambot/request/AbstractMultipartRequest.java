package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.impl.TelegramApi;

/**
 * stas
 * 5/1/16.
 */
abstract public class AbstractMultipartRequest<T extends AbstractMultipartRequest> extends AbstractSendRequest<T> {

    private final boolean isMultipart;

    public AbstractMultipartRequest(TelegramApi api, Object chatId, boolean isMultipart) {
        super(api, chatId);
        this.isMultipart = isMultipart;
    }

    @Override
    public boolean isMultipart() {
        return isMultipart;
    }

    @Override
    abstract public String getFileName();

    @Override
    abstract public String getContentType();
}
