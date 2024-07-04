package com.pengrad.telegrambot.model.request;

import com.pengrad.telegrambot.request.ContentTypes;

import java.io.File;
import java.io.Serializable;

public class InputPaidMediaPhoto extends InputPaidMedia implements Serializable {

    private final static long serialVersionUID = 1L;

    public InputPaidMediaPhoto(String media) {
        super("photo", media);
    }

    public InputPaidMediaPhoto(File media) {
        super("photo", media);
    }

    public InputPaidMediaPhoto(byte[] media) {
        super("photo", media);
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
