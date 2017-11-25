package com.pengrad.telegrambot.model.request;

import java.io.File;
import java.io.Serializable;

/**
 * Stas Parshin
 * 23 November 2017
 */
public class InputMediaPhoto extends InputMedia implements Serializable {
    private final static long serialVersionUID = 0L;

    private String caption;

    public InputMediaPhoto(String media) {
        super("photo", media);
    }

    public InputMediaPhoto(File media) {
        super("photo", media);
    }

    public InputMediaPhoto(byte[] media) {
        super("photo", media);
    }

    public InputMediaPhoto caption(String caption) {
        this.caption = caption;
        return this;
    }
}
