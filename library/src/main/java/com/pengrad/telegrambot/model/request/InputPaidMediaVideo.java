package com.pengrad.telegrambot.model.request;

import com.pengrad.telegrambot.request.ContentTypes;

import java.io.File;
import java.io.Serializable;

public class InputPaidMediaVideo extends InputPaidMedia implements Serializable {

    private final static long serialVersionUID = 1L;

    private Integer width, height, duration;
    private Boolean supports_streaming;
    private String thumbnail;
    private String cover;
    private Integer start_timestamp;

    public InputPaidMediaVideo(String media) {
        super("video", media);
    }

    public InputPaidMediaVideo(File media) {
        super("video", media);
    }

    public InputPaidMediaVideo(byte[] media) {
        super("video", media);
    }

    public InputPaidMediaVideo width(Integer width) {
        this.width = width;
        return this;
    }

    public InputPaidMediaVideo height(Integer height) {
        this.height = height;
        return this;
    }

    public InputPaidMediaVideo duration(Integer duration) {
        this.duration = duration;
        return this;
    }

    public InputPaidMediaVideo supportsStreaming(boolean supportsStreaming) {
        this.supports_streaming = supportsStreaming;
        return this;
    }

    public InputPaidMediaVideo thumbnail(File thumbnail) {
        this.thumbnail = addAttachment(thumbnail);
        return this;
    }

    public InputPaidMediaVideo thumbnail(byte[] thumbnail) {
        this.thumbnail = addAttachment(thumbnail);
        return this;
    }

    public InputPaidMediaVideo cover(File cover) {
        this.cover = addAttachment(cover);
        return this;
    }

    public InputPaidMediaVideo cover(byte[] cover) {
        this.cover = addAttachment(cover);
        return this;
    }

    public InputPaidMediaVideo startTimestamp(Integer startTimestamp) {
        this.start_timestamp = startTimestamp;
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
