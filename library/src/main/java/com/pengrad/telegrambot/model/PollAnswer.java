package com.pengrad.telegrambot.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

/**
 * Stas Parshin
 * 25 January 2020
 */
public class PollAnswer implements Serializable {
    private final static long serialVersionUID = 0L;

    private String poll_id;
    private User user;
    private Integer[] option_ids;

    public String pollId() {
        return poll_id;
    }

    public User user() {
        return user;
    }

    public Integer[] optionIds() {
        return option_ids;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PollAnswer that = (PollAnswer) o;

        if (!Objects.equals(poll_id, that.poll_id)) return false;
        if (!Objects.equals(user, that.user)) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(option_ids, that.option_ids);
    }

    @Override
    public int hashCode() {
        int result = poll_id != null ? poll_id.hashCode() : 0;
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(option_ids);
        return result;
    }

    @Override
    public String toString() {
        return "PollAnswer{" +
                "poll_id='" + poll_id + '\'' +
                ", user=" + user +
                ", option_ids=" + Arrays.toString(option_ids) +
                '}';
    }
}
