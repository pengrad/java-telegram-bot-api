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

        if (!Objects.equals(file_id, audio.file_id)) return false;
        if (!Objects.equals(file_unique_id, audio.file_unique_id)) return false;
        if (!Objects.equals(duration, audio.duration)) return false;
        if (!Objects.equals(performer, audio.performer)) return false;
        if (!Objects.equals(title, audio.title)) return false;
        if (!Objects.equals(mime_type, audio.mime_type)) return false;
        if (!Objects.equals(file_size, audio.file_size)) return false;
        return Objects.equals(thumb, audio.thumb);
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
                ", mime_type='" + mime_type + '\'' +
                ", file_size=" + file_size +
                ", thumb=" + thumb +
                '}';
    }
}
