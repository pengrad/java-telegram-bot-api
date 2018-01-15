package com.pengrad.telegrambot.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * stas
 * 10/21/15.
 */
public class Voice implements Serializable {
    private final static long serialVersionUID = 0L;

    private String file_id;
    private Integer duration;
    private String mime_type;
    private Integer file_size;

    public String fileId() {
        return file_id;
    }

    public Integer duration() {
        return duration;
    }

    public String mimeType() {
        return mime_type;
    }

    public Integer fileSize() {
        return file_size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Voice voice = (Voice) o;

        if (file_id != null ? !file_id.equals(voice.file_id) : voice.file_id != null) return false;
        if (duration != null ? !duration.equals(voice.duration) : voice.duration != null) return false;
        if (mime_type != null ? !mime_type.equals(voice.mime_type) : voice.mime_type != null) return false;
        return file_size != null ? file_size.equals(voice.file_size) : voice.file_size == null;
    }

    @Override
    public int hashCode() {
        return file_id != null ? file_id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("file_id", file_id)
                .append("duration", duration)
                .append("mime_type", mime_type)
                .append("file_size", file_size)
                .toString();
    }
}