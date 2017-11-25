package com.pengrad.telegrambot.model.request;

import java.io.File;
import java.io.Serializable;

/**
 * Stas Parshin
 * 23 November 2017
 */
public class InputMediaVideo extends InputMedia implements Serializable {
    private final static long serialVersionUID = 0L;

    private String caption;
    private Integer width, height, duration;

    public InputMediaVideo(String media) {
        super("video", media);
    }

    public InputMediaVideo(File media) {
        super("video", media);
    }

    public InputMediaVideo(byte[] media) {
        super("video", media);
    }

    public InputMediaVideo caption(String caption) {
        this.caption = caption;
        return this;
    }

    public InputMediaVideo width(Integer width) {
        this.width = width;
        return this;
    }

    public InputMediaVideo height(Integer height) {
        this.height = height;
        return this;
    }

    public InputMediaVideo duration(Integer duration) {
        this.duration = duration;
        return this;
    }
}
