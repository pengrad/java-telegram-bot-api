package com.pengrad.telegrambot.model;

import java.io.Serializable;

/**
 * Stas Parshin
 * 17 April 2019
 */
public class PollOption implements Serializable {
    private final static long serialVersionUID = 0L;

    private String text;
    private Integer voter_count;

    public String text() {
        return text;
    }

    public Integer voterCount() {
        return voter_count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PollOption that = (PollOption) o;

        if (text != null ? !text.equals(that.text) : that.text != null) return false;
        return voter_count != null ? voter_count.equals(that.voter_count) : that.voter_count == null;
    }

    @Override
    public int hashCode() {
        int result = text != null ? text.hashCode() : 0;
        result = 31 * result + (voter_count != null ? voter_count.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PollOption{" +
                "text='" + text + '\'' +
                ", voter_count=" + voter_count +
                '}';
    }
}
