package com.pengrad.telegrambot.model.request;

import com.pengrad.telegrambot.request.ContentTypes;

import java.io.File;
import java.io.Serializable;

/**
 * Stas Parshin
 * 23 November 2017
 */
public class InputMediaVideo extends InputMedia<InputMediaVideo> implements Serializable {
    private final static long serialVersionUID = 1L;

    private Integer width, height, duration;
    private Boolean supports_streaming;
    private Boolean has_spoiler;

    public InputMediaVideo(String media) {
        super("video", media);
    }

    public InputMediaVideo(File media) {
        super("video", media);
    }

    public InputMediaVideo(byte[] media) {
        super("video", media);
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

    public InputMediaVideo supportsStreaming(boolean supportsStreaming) {
        this.supports_streaming = supportsStreaming;
        return this;
    }

    public InputMediaVideo hasSpoiler(boolean has_spoiler) {
        this.has_spoiler = has_spoiler;
        return this;
    }

    @Override
    public String getDefaultFileName() {
        return ContentTypes.VIDEO_FILE_NAME;
    }

    @Override
    public String getDefaultContentType() {
        return ContentTypes.VIDEO_MIME_TYPE;
    }
}
