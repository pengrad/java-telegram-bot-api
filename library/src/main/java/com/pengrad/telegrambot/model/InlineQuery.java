package com.pengrad.telegrambot.model;

import java.io.Serializable;

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

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (from != null ? !from.equals(that.from) : that.from != null) return false;
        if (location != null ? !location.equals(that.location) : that.location != null) return false;
        if (query != null ? !query.equals(that.query) : that.query != null) return false;
        return offset != null ? offset.equals(that.offset) : that.offset == null;

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
