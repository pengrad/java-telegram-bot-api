package com.pengrad.telegrambot.model;

import java.io.Serializable;
import java.util.Objects;

public class VoiceChatScheduled implements Serializable {

    private final static long serialVersionUID = 0L;

    private Integer start_date;

    public Integer startDate() {
        return start_date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VoiceChatScheduled that = (VoiceChatScheduled) o;
        return Objects.equals(start_date, that.start_date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(start_date);
    }

    @Override
    public String toString() {
        return "VoiceChatScheduled{" +
                "start_date=" + start_date +
                '}';
    }
}
