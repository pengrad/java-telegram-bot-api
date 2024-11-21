package com.pengrad.telegrambot.model;

import java.io.Serializable;
import java.util.Objects;

public class Gift implements Serializable {
    private final static long serialVersionUID = 0L;

    private String id;
    private Sticker sticker;
    private Integer star_count;
    private Integer total_count;
    private Integer remaining_count;

    public String id() {
        return id;
    }

    public Sticker sticker() {
        return sticker;
    }

    public Integer starCount() {
        return star_count;
    }

    public Integer totalCount() {
        return total_count;
    }

    public Integer remainingCount() {
        return remaining_count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Gift gift = (Gift) o;
        return Objects.equals(id, gift.id) && Objects.equals(sticker, gift.sticker) && Objects.equals(star_count, gift.star_count) && Objects.equals(total_count, gift.total_count) && Objects.equals(remaining_count, gift.remaining_count);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(id);
        result = 31 * result + Objects.hashCode(sticker);
        result = 31 * result + Objects.hashCode(star_count);
        result = 31 * result + Objects.hashCode(total_count);
        result = 31 * result + Objects.hashCode(remaining_count);
        return result;
    }

    @Override
    public String toString() {
        return "Gift{" +
            "id='" + id + '\'' +
            ", sticker=" + sticker +
            ", star_count=" + star_count +
            ", total_count=" + total_count +
            ", remaining_count=" + remaining_count +
            '}';
    }
}
