package com.pengrad.telegrambot.model;

/**
 * stas
 * 8/4/15.
 */
public class PhotoSize {

    private String file_id;
    private Integer width;
    private Integer height;
    private Integer file_size;

    PhotoSize() {
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

        if (file_id != null ? !file_id.equals(photoSize.file_id) : photoSize.file_id != null) return false;
        if (width != null ? !width.equals(photoSize.width) : photoSize.width != null) return false;
        if (height != null ? !height.equals(photoSize.height) : photoSize.height != null) return false;
        return file_size != null ? file_size.equals(photoSize.file_size) : photoSize.file_size == null;
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
