package com.pengrad.telegrambot.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * stas
 * 1/12/16.
 */
public class InlineQuery implements Serializable {
    private final static long serialVersionUID = 0L;

    private String id;
    private User from;
    private Location location;
    private String query;
    private String offset;

    public String id() {
        return id;
    }

    public User from() {
        return from;
    }

    public Location location() {
        return location;
    }

    public String query() {
        return query;
    }

    public String offset() {
        return offset;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InlineQuery that = (InlineQuery) o;

        if (!Objects.equals(id, that.id)) return false;
        if (!Objects.equals(from, that.from)) return false;
        if (!Objects.equals(location, that.location)) return false;
        if (!Objects.equals(query, that.query)) return false;
        return Objects.equals(offset, that.offset);

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "InlineQuery{" +
                "id='" + id + '\'' +
                ", from=" + from +
                ", location=" + location +
                ", query='" + query + '\'' +
                ", offset='" + offset + '\'' +
                '}';
    }
}
