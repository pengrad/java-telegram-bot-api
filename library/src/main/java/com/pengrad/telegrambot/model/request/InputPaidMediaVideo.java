package com.pengrad.telegrambot.model.request;

import com.pengrad.telegrambot.AttachName;
import com.pengrad.telegrambot.request.ContentTypes;

import java.io.File;
import java.io.Serializable;
import java.util.Map;

public class InputPaidMediaVideo extends InputPaidMedia implements Serializable {

    private final static long serialVersionUID = 1L;

    private Integer width, height, duration;
    private Boolean supports_streaming;
    private String thumbnail;

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
        String attachName = AttachName.next();
        attachments.put(attachName, thumbnail);
        this.thumbnail = "attach://" + attachName;
        return this;
    }

    public InputPaidMediaVideo thumbnail(byte[] thumbnail) {
        String attachName = AttachName.next();
        attachments.put(attachName, thumbnail);
        this.thumbnail = "attach://" + attachName;
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
