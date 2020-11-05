package com.pengrad.telegrambot.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * stas
 * 8/5/15.
 */
public class Audio implements Serializable {
    private final static long serialVersionUID = 0L;

    private String file_id;
    private String file_unique_id;
    private Integer duration;
    private String performer;
    private String title;
    private String file_name;
    private String mime_type;
    private Integer file_size;
    private PhotoSize thumb;

    public String fileId() {
        return file_id;
    }

    public String fileUniqueId() {
        return file_unique_id;
    }

    public Integer duration() {
        return duration;
    }

    public String performer() {
        return performer;
    }

    public String title() {
        return title;
    }

    public String fileName() {
        return file_name;
    }

    public String mimeType() {
        return mime_type;
    }

    public Integer fileSize() {
        return file_size;
    }

    public PhotoSize thumb() {
        return thumb;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Audio audio = (Audio) o;
        return Objects.equals(file_id, audio.file_id) &&
                Objects.equals(file_unique_id, audio.file_unique_id) &&
                Objects.equals(duration, audio.duration) &&
                Objects.equals(performer, audio.performer) &&
                Objects.equals(title, audio.title) &&
                Objects.equals(file_name, audio.file_name) &&
                Objects.equals(mime_type, audio.mime_type) &&
                Objects.equals(file_size, audio.file_size) &&
                Objects.equals(thumb, audio.thumb);
    }

    @Override
    public int hashCode() {
        return file_id != null ? file_id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Audio{" +
                "file_id='" + file_id + '\'' +
                ", file_unique_id='" + file_unique_id + '\'' +
                ", duration=" + duration +
                ", performer='" + performer + '\'' +
                ", title='" + title + '\'' +
                ", file_name='" + file_name + '\'' +
                ", mime_type='" + mime_type + '\'' +
                ", file_size=" + file_size +
                ", thumb=" + thumb +
                '}';
    }
}
