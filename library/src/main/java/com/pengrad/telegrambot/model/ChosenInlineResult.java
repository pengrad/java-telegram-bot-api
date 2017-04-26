package com.pengrad.telegrambot.model;

import java.io.Serializable;

/**
 * stas
 * 1/20/16.
 */
public class ChosenInlineResult implements Serializable {
    private final static long serialVersionUID = 0L;

    private String result_id;
    private User from;
    private Location location;
    private String inline_message_id;
    private String query;

    public String resultId() {
        return result_id;
    }

    public User from() {
        return from;
    }

    public Location location() {
        return location;
    }

    public String inlineMessageId() {
        return inline_message_id;
    }

    public String query() {
        return query;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ChosenInlineResult that = (ChosenInlineResult) o;

        if (result_id != null ? !result_id.equals(that.result_id) : that.result_id != null) return false;
        if (from != null ? !from.equals(that.from) : that.from != null) return false;
        if (location != null ? !location.equals(that.location) : that.location != null) return false;
        if (inline_message_id != null ? !inline_message_id.equals(that.inline_message_id) : that.inline_message_id != null)
            return false;
        return query != null ? query.equals(that.query) : that.query == null;

    }

    @Override
    public int hashCode() {
        return result_id != null ? result_id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "ChosenInlineResult{" +
                "result_id='" + result_id + '\'' +
                ", from=" + from +
                ", location=" + location +
                ", inline_message_id='" + inline_message_id + '\'' +
                ", query='" + query + '\'' +
                '}';
    }
}
