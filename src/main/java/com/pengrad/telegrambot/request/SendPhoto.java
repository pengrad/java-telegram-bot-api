package com.pengrad.telegrambot.request;

import java.io.File;

/**
 * stas
 * 5/1/16.
 */
public class SendPhoto extends AbstractMultipartRequest<SendPhoto> {

    public SendPhoto(Object chatId, String photo) {
        super(chatId, photo);
    }

    public SendPhoto(Object chatId, File photo) {
        super(chatId, photo);
    }

    public SendPhoto(Object chatId, byte[] photo) {
        super(chatId, photo);
    }

    public SendPhoto caption(String caption) {
        return add("caption", caption);
    }

    @Override
    protected String getFileParamName() {
        return "photo";
    }

    @Override
    public String getDefaultFileName() {
        return ContentTypes.PHOTO_FILE_NAME;
    }

    @Override
    public String getContentType() {
        return ContentTypes.PHOTO_MIME_TYPE;
    }
}
