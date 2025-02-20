package com.pengrad.telegrambot.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * Stas Parshin
 * 03 October 2016
 */
public class Animation implements Serializable {
    private final static long serialVersionUID = 0L;

    private String file_id;
    private String file_unique_id;
    private Integer width;
    private Integer height;
    private Integer duration;
    private PhotoSize thumbnail;
    private String file_name;
    private String mime_type;
    private Long file_size;

    public String fileId() {
        return file_id;
    }

    public String fileUniqueId() {
        return file_unique_id;
    }

    public Integer width() {
        return width;
    }

    public Integer height() {
        return height;
    }

    public Integer duration() {
        return duration;
    }

    public PhotoSize thumbnail() {
        return thumbnail;
    }

    public String fileName() {
        return file_name;
    }

    public String mimeType() {
        return mime_type;
    }

    public Long fileSize() {
        return file_size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animation animation = (Animation) o;
        return Objects.equals(file_id, animation.file_id) && Objects.equals(file_unique_id, animation.file_unique_id) && Objects.equals(width, animation.width) && Objects.equals(height, animation.height) && Objects.equals(duration, animation.duration) && Objects.equals(thumbnail, animation.thumbnail) && Objects.equals(file_name, animation.file_name) && Objects.equals(mime_type, animation.mime_type) && Objects.equals(file_size, animation.file_size);
    }

    @Override
    public int hashCode() {
        return file_id != null ? file_id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Animation{" +
                "file_id='" + file_id + '\'' +
                ", file_unique_id='" + file_unique_id + '\'' +
                ", width=" + width +
                ", height=" + height +
                ", duration=" + duration +
                ", thumbnail=" + thumbnail +
                ", file_name='" + file_name + '\'' +
                ", mime_type='" + mime_type + '\'' +
                ", file_size=" + file_size +
                '}';
    }
}
