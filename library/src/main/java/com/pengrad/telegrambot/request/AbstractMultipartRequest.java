package com.pengrad.telegrambot.request;

import java.io.File;

/**
 * stas
 * 5/1/16.
 */
abstract public class AbstractMultipartRequest<T extends AbstractMultipartRequest<T>> extends AbstractSendRequest<T> {

    private boolean isMultipart;
    private String fileName;
    private String contentType;

    public AbstractMultipartRequest(Object chatId, Object file) {
        super(chatId);
        if (file instanceof String) {
            isMultipart = false;
        } else if (file instanceof File) {
            isMultipart = true;
            fileName = ((File) file).getName();
        } else if (file instanceof byte[]) {
            isMultipart = true;
        } else {
            throw new IllegalArgumentException("Sending data should be String, File or byte[]");
        }
        add(getFileParamName(), file);
    }

    public T fileName(String fileName) {
        this.fileName = fileName;
        return thisAsT;
    }

    public T contentType(String contentType) {
        this.contentType = contentType;
        return thisAsT;
    }

    protected T thumbnail(Object thumbnail) {
        isMultipart = true;
        return add("thumbnail", thumbnail);
    }

    @Override
    public boolean isMultipart() {
        return isMultipart;
    }

    @Override
    public String getFileName() {
        if (fileName != null && !fileName.isEmpty()) {
            return fileName;
        } else {
            return getDefaultFileName();
        }
    }

    @Override
    public String getContentType() {
        return (contentType != null && !contentType.isEmpty()) ? contentType : getDefaultContentType();
    }

    abstract protected String getDefaultFileName();

    abstract protected String getDefaultContentType();

    abstract protected String getFileParamName();
}
