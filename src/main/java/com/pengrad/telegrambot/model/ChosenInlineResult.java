package com.pengrad.telegrambot.model;

/**
 * stas
 * 1/20/16.
 */
public class ChosenInlineResult {

    private String result_id;
    private User from;
    private String query;

    ChosenInlineResult() {
    }

    public String resultId() {
        return result_id;
    }

    public User from() {
        return from;
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
                ", query='" + query + '\'' +
                '}';
    }
}
