package com.pengrad.telegrambot.model;

/**
 * stas
 * 8/4/15.
 */
public class PhotoSize {

    private final String file_id;
    private final Integer width;
    private final Integer height;
    private final Integer file_size;

    public PhotoSize(String file_id, Integer width, Integer height, Integer file_size) {
        this.file_id = file_id;
        this.width = width;
        this.height = height;
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

    public Integer fileSize() {
        return file_size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PhotoSize photoSize = (PhotoSize) o;

        if (!file_id.equals(photoSize.file_id)) return false;
        if (!width.equals(photoSize.width)) return false;
        if (!height.equals(photoSize.height)) return false;
        return !(file_size != null ? !file_size.equals(photoSize.file_size) : photoSize.file_size != null);

    }

    @Override
    public int hashCode() {
        return file_id.hashCode();
    }

    @Override
    public String toString() {
        return "PhotoSize{" +
                "file_id='" + file_id + '\'' +
                ", width=" + width +
                ", height=" + height +
                ", file_size=" + file_size +
                '}';
    }
}
