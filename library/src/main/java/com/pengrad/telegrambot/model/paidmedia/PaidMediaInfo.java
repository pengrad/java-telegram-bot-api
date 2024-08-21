package com.pengrad.telegrambot.model.paidmedia;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

public class PaidMediaInfo implements Serializable {

    private final static long serialVersionUID = 0L;

    private Integer star_count;

    private PaidMedia[] paid_media;

    public Integer starCount() {
        return star_count;
    }

    public PaidMedia[] paidMedia() {
        return paid_media;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaidMediaInfo that = (PaidMediaInfo) o;
        return Objects.equals(star_count, that.star_count) && Objects.deepEquals(paid_media, that.paid_media);
    }

    @Override
    public int hashCode() {
        return Objects.hash(star_count, Arrays.hashCode(paid_media));
    }

    @Override
    public String toString() {
        return "PaidMediaInfo{" +
                "star_count='" + star_count + "'," +
                "paid_media='" + Arrays.toString(paid_media) + "'" +
                '}';
    }

}
