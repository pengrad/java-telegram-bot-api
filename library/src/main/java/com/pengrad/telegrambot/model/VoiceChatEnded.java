package com.pengrad.telegrambot.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * Stas Parshin
 * 10 March 2021
 */
public class VoiceChatEnded implements Serializable {
    private final static long serialVersionUID = 0L;

    private Integer duration;

    public Integer duration() {
        return duration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VoiceChatEnded that = (VoiceChatEnded) o;
        return Objects.equals(duration, that.duration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(duration);
    }

    @Override
    public String toString() {
        return "VoiceChatEnded{" +
                "duration=" + duration +
                '}';
    }
}
