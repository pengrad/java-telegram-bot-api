package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.impl.TelegramApi;

import java.io.File;

/**
 * stas
 * 5/1/16.
 */
public class SendPhotoRequest extends AbstractMultipartRequest<SendPhotoRequest> {

    public SendPhotoRequest(TelegramApi api, Object chatId, File photo) {
        super(api, chatId, true);
        add("photo", photo);
    }

    public SendPhotoRequest caption(String caption) {
        add("caption", caption);
        return this;
    }

    @Override
    public String getMethod() {
        return "sendPhoto";
    }

    @Override
    public String getFileName() {
        return ContentTypes.PHOTO_FILE_NAME;
    }

    @Override
    public String getContentType() {
        return ContentTypes.PHOTO_MIME_TYPE;
    }
}
