package com.pengrad.telegrambot.request;

/**
 * stas
 * 5/1/16.
 */
public class SendPhoto extends AbstractMultipartRequest<SendPhoto> {

    public SendPhoto(Object chatId, Object photo, boolean isMultipart) {
        super(chatId, isMultipart);
        add("photo", photo);
    }

    public SendPhoto caption(String caption) {
        return add("caption", caption);
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
