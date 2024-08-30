package com.pengrad.telegrambot.model.paidmedia;

import com.pengrad.telegrambot.model.Video;

import java.util.Arrays;
import java.util.Objects;

public class PaidMediaVideo extends PaidMedia {

    public final static String TYPE = "video";

    private Video video;

    public PaidMediaVideo() {
        super(TYPE);
    }

    public Video getVideo() {
        return video;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaidMediaVideo that = (PaidMediaVideo) o;
        return Objects.equals(type(), that.type()) &&
                Objects.equals(video, that.video);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type(), video);
    }

    @Override
    public String toString() {
        return "PaidMediaVideo{" +
                "video=" + video +
                '}';
    }
}
