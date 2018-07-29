package com.pengrad.telegrambot.model.request;

import com.pengrad.telegrambot.request.ContentTypes;

import java.io.File;
import java.io.Serializable;

/**
 * Stas Parshin
 * 23 November 2017
 */
public class InputMediaPhoto extends InputMedia<InputMediaPhoto> implements Serializable {
    private final static long serialVersionUID = 1L;

    public InputMediaPhoto(String media) {
        super("photo", media);
    }

    public InputMediaPhoto(File media) {
        super("photo", media);
    }

    public InputMediaPhoto(byte[] media) {
        super("photo", media);
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
