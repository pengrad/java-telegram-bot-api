package com.pengrad.telegrambot.model;

import java.io.Serializable;
import java.util.Objects;

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

        if (!Objects.equals(result_id, that.result_id)) return false;
        if (!Objects.equals(from, that.from)) return false;
        if (!Objects.equals(location, that.location)) return false;
        if (!Objects.equals(inline_message_id, that.inline_message_id))
            return false;
        return Objects.equals(query, that.query);

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
