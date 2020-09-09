package com.pengrad.telegrambot.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * Stas Parshin
 * 23 May 2017
 */
public class VideoNote implements Serializable {
    private final static long serialVersionUID = 0L;

    private String file_id;
    private String file_unique_id;
    private Integer length;
    private Integer duration;
    private PhotoSize thumb;
    private Integer file_size;

    public String fileId() {
        return file_id;
    }

    public String fileUniqueId() {
        return file_unique_id;
    }

    public Integer length() {
        return length;
    }

    public Integer duration() {
        return duration;
    }

    public PhotoSize thumb() {
        return thumb;
    }

    public Integer fileSize() {
        return file_size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VideoNote videoNote = (VideoNote) o;

        if (!Objects.equals(file_id, videoNote.file_id)) return false;
        if (!Objects.equals(file_unique_id, videoNote.file_unique_id))
            return false;
        if (!Objects.equals(length, videoNote.length)) return false;
        if (!Objects.equals(duration, videoNote.duration)) return false;
        if (!Objects.equals(thumb, videoNote.thumb)) return false;
        return Objects.equals(file_size, videoNote.file_size);
    }

    @Override
    public int hashCode() {
        return file_id != null ? file_id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "VideoNote{" +
                "file_id='" + file_id + '\'' +
                ", file_unique_id='" + file_unique_id + '\'' +
                ", length=" + length +
                ", duration=" + duration +
                ", thumb=" + thumb +
                ", file_size=" + file_size +
                '}';
    }
}
