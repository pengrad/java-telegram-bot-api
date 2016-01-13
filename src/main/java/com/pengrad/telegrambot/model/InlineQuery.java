package com.pengrad.telegrambot.model;

/**
 * stas
 * 1/12/16.
 */
public class InlineQuery {

    private String id;
    private User from;
    private String query;
    private String offset;

    InlineQuery() {
    }

    public String id() {
        return id;
    }

    public User from() {
        return from;
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
        if (query != null ? !query.equals(that.query) : that.query != null) return false;
        return offset != null ? offset.equals(that.offset) : that.offset == null;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "InlineQuery{" +
                "id='" + id + '\'' +
                ", from=" + from +
                ", query='" + query + '\'' +
                ", offset='" + offset + '\'' +
                '}';
    }
}
