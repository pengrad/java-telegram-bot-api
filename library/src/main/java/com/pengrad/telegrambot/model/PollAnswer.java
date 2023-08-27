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
    private Chat voter_chat;
    private User user;
    private Integer[] option_ids;

    public String pollId() {
        return poll_id;
    }

    public Chat voterChat() {
        return voter_chat;
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
        return Objects.equals(poll_id, that.poll_id) &&
                Objects.equals(voter_chat, that.voter_chat) &&
                Objects.equals(user, that.user) &&
                Arrays.equals(option_ids, that.option_ids);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(poll_id, voter_chat, user);
        result = 31 * result + Arrays.hashCode(option_ids);
        return result;
    }

    @Override
    public String toString() {
        return "PollAnswer{" + "poll_id='" + poll_id + '\'' + ", voter_chat=" + voter_chat + ", user=" + user + ", option_ids=" + Arrays.toString(option_ids) + '}';
    }
}
