package com.pengrad.telegrambot.model;

/**
 * stas
 * 8/5/15.
 */
public class Sticker {

    private String file_id;
    private Integer width;
    private Integer height;
    private PhotoSize thumb;
    private Integer file_size;

    Sticker() {
    }

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
        return file_size != null ? file_size.equals(sticker.file_size) : sticker.file_size == null;
    }

    @Override
    public int hashCode() {
        return file_id.hashCode();
    }

    @Override
    public String toString() {
        return "Sticker{" +
                "file_id='" + file_id + '\'' +
                ", width=" + width +
                ", height=" + height +
                ", thumb=" + thumb +
                ", file_size=" + file_size +
                '}';
    }
}
