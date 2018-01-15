package com.pengrad.telegrambot.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * stas
 * 8/4/15.
 */
public class PhotoSize implements Serializable {
    private final static long serialVersionUID = 0L;

    private String file_id;
    private Integer width;
    private Integer height;
    private Integer file_size;

    public String fileId() {
        return file_id;
    }

    public Integer width() {
        return width;
    }

    public Integer height() {
        return height;
    }

    public Integer fileSize() {
        return file_size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PhotoSize photoSize = (PhotoSize) o;

        if (file_id != null ? !file_id.equals(photoSize.file_id) : photoSize.file_id != null) return false;
        if (width != null ? !width.equals(photoSize.width) : photoSize.width != null) return false;
        if (height != null ? !height.equals(photoSize.height) : photoSize.height != null) return false;
        return file_size != null ? file_size.equals(photoSize.file_size) : photoSize.file_size == null;
    }

    @Override
    public int hashCode() {
        return file_id != null ? file_id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("file_id", file_id)
                .append("width", width)
                .append("height", height)
                .append("file_size", file_size)
                .toString();
    }
}
