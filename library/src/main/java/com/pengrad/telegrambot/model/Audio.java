package com.pengrad.telegrambot.model;

import java.io.Serializable;

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

        if (file_id != null ? !file_id.equals(audio.file_id) : audio.file_id != null) return false;
        if (file_unique_id != null ? !file_unique_id.equals(audio.file_unique_id) : audio.file_unique_id != null) return false;
        if (duration != null ? !duration.equals(audio.duration) : audio.duration != null) return false;
        if (performer != null ? !performer.equals(audio.performer) : audio.performer != null) return false;
        if (title != null ? !title.equals(audio.title) : audio.title != null) return false;
        if (mime_type != null ? !mime_type.equals(audio.mime_type) : audio.mime_type != null) return false;
        if (file_size != null ? !file_size.equals(audio.file_size) : audio.file_size != null) return false;
        return thumb != null ? thumb.equals(audio.thumb) : audio.thumb == null;
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
