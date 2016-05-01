package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.impl.TelegramApi;

/**
 * stas
 * 5/1/16.
 */
public class SendPhotoRequest extends AbstractMultipartRequest<SendPhotoRequest> {

    public SendPhotoRequest(TelegramApi api, Object chatId, Object photo, boolean isMultipart) {
        super(api, chatId, isMultipart);
        add("photo", photo);
    }

    public SendPhotoRequest caption(String caption) {
        return add("caption", caption);
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
