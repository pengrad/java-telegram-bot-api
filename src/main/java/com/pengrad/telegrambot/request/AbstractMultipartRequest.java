package com.pengrad.telegrambot.request;

/**
 * stas
 * 5/1/16.
 */
abstract public class AbstractMultipartRequest<T extends AbstractMultipartRequest> extends AbstractSendRequest<T> {

    private final boolean isMultipart;

    public AbstractMultipartRequest(Object chatId, boolean isMultipart) {
        super(chatId);
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
