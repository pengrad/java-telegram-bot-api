package com.pengrad.telegrambot.model.paidmedia;

import java.util.Objects;

public class PaidMediaPreview extends PaidMedia {

    public final static String TYPE = "preview";

    private Integer width;

    private Integer height;

    private Integer duration;

    public PaidMediaPreview() {
        super(TYPE);
    }

    public Integer getWidth() {
        return width;
    }

    public Integer getHeight() {
        return height;
    }

    public Integer getDuration() {
        return duration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaidMediaPreview that = (PaidMediaPreview) o;
        return Objects.equals(type(), that.type()) &&
                Objects.equals(width, that.width) &&
                Objects.equals(height, that.height) &&
                Objects.equals(duration, that.duration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type(), width, height, duration);
    }

    @Override
    public String toString() {
        return "PaidMediaPreview{" +
                "width=" + width +
                ", height=" + height +
                ", duration=" + duration +
                '}';
    }
}
