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

    private Boolean has_spoiler;

    public InputMediaPhoto(String media) {
        super("photo", media);
    }

    public InputMediaPhoto(File media) {
        super("photo", media);
    }

    public InputMediaPhoto(byte[] media) {
        super("photo", media);
    }

    public InputMediaPhoto hasSpoiler(boolean has_spoiler) {
        this.has_spoiler = has_spoiler;
        return this;
    }

    @Override
    public String getDefaultFileName() {
        return ContentTypes.PHOTO_FILE_NAME;
    }

    @Override
    public String getDefaultContentType() {
        return ContentTypes.PHOTO_MIME_TYPE;
    }
}
