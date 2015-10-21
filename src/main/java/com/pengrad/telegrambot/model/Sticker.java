package com.pengrad.telegrambot.model;

/**
 * stas
 * 8/5/15.
 */
public class Sticker {

    private final String file_id;
    private final Integer width;
    private final Integer height;
    private final PhotoSize thumb;
    private final Integer file_size;

    public Sticker(String file_id, Integer width, Integer height, PhotoSize thumb, Integer file_size) {
        this.file_id = file_id;
        this.width = width;
        this.height = height;
        this.thumb = thumb;
        this.file_size = file_size;
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

        if (!file_id.equals(sticker.file_id)) return false;
        if (!width.equals(sticker.width)) return false;
        if (!height.equals(sticker.height)) return false;
        if (thumb != null ? !thumb.equals(sticker.thumb) : sticker.thumb != null) return false;
        return !(file_size != null ? !file_size.equals(sticker.file_size) : sticker.file_size != null);

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
