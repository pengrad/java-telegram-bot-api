package com.pengrad.telegrambot.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * stas
 * 8/5/15.
 */
public class Sticker implements Serializable {
    private final static long serialVersionUID = 0L;

    private String file_id;
    private Integer width;
    private Integer height;
    private PhotoSize thumb;
    private String emoji;
    private String set_name;
    private MaskPosition mask_position;
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

    public PhotoSize thumb() {
        return thumb;
    }

    public String emoji() {
        return emoji;
    }

    public String setName() {
        return set_name;
    }

    public MaskPosition maskPosition() {
        return mask_position;
    }

    public Integer fileSize() {
        return file_size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sticker sticker = (Sticker) o;

        if (file_id != null ? !file_id.equals(sticker.file_id) : sticker.file_id != null) return false;
        if (width != null ? !width.equals(sticker.width) : sticker.width != null) return false;
        if (height != null ? !height.equals(sticker.height) : sticker.height != null) return false;
        if (thumb != null ? !thumb.equals(sticker.thumb) : sticker.thumb != null) return false;
        if (emoji != null ? !emoji.equals(sticker.emoji) : sticker.emoji != null) return false;
        if (set_name != null ? !set_name.equals(sticker.set_name) : sticker.set_name != null) return false;
        if (mask_position != null ? !mask_position.equals(sticker.mask_position) : sticker.mask_position != null) return false;
        return file_size != null ? file_size.equals(sticker.file_size) : sticker.file_size == null;
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
                .append("thumb", thumb)
                .append("emoji", emoji)
                .append("set_name", set_name)
                .append("mask_position", mask_position)
                .append("file_size", file_size)
                .toString();
    }
}
