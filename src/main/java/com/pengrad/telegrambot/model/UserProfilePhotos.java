package com.pengrad.telegrambot.model;

import java.util.Arrays;

/**
 * stas
 * 8/5/15.
 */
public class UserProfilePhotos {

    private Integer total_count;
    private PhotoSize[][] photos;

    UserProfilePhotos() {
    }

    public Integer totalCount() {
        return total_count;
    }

    public PhotoSize[][] photos() {
        return photos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserProfilePhotos that = (UserProfilePhotos) o;

        if (total_count != null ? !total_count.equals(that.total_count) : that.total_count != null) return false;
        return Arrays.deepEquals(photos, that.photos);
    }

    @Override
    public int hashCode() {
        int result = total_count.hashCode();
        result = 31 * result + Arrays.deepHashCode(photos);
        return result;
    }

    @Override
    public String toString() {
        return "UserProfilePhotos{" +
                "total_count=" + total_count +
                ", photos=" + Arrays.toString(photos) +
                '}';
    }
}
