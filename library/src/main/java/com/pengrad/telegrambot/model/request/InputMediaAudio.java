package com.pengrad.telegrambot.model.request;

import com.pengrad.telegrambot.request.ContentTypes;

import java.io.File;
import java.io.Serializable;

/**
 * Stas Parshin
 * 28 July 2018
 */
public class InputMediaAudio extends InputMedia<InputMediaAudio> implements Serializable {
    private final static long serialVersionUID = 0L;

    private Integer duration;
    private String performer, title;

    public InputMediaAudio(String media) {
        super("audio", media);
    }

    public InputMediaAudio(File media) {
        super("audio", media);
    }

    public InputMediaAudio(byte[] media) {
        super("audio", media);
    }

    public InputMediaAudio duration(Integer duration) {
        this.duration = duration;
        return this;
    }

    public InputMediaAudio performer(String performer) {
        this.performer = performer;
        return this;
    }

    public InputMediaAudio title(String title) {
        this.title = title;
        return this;
    }

    @Override
    public String getDefaultFileName() {
        return ContentTypes.AUDIO_FILE_NAME;
    }

    @Override
    public String getContentType() {
        return ContentTypes.AUDIO_MIME_TYPE;
    }
}
