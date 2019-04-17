package com.pengrad.telegrambot.model;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Stas Parshin
 * 17 April 2019
 */
public class Poll implements Serializable {
    private final static long serialVersionUID = 0L;

    private String id;
    private String question;
    private PollOption[] options;
    private Boolean is_closed;

    public String id() {
        return id;
    }

    public String question() {
        return question;
    }

    public PollOption[] options() {
        return options;
    }

    public Boolean isClosed() {
        return is_closed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Poll poll = (Poll) o;

        if (id != null ? !id.equals(poll.id) : poll.id != null) return false;
        if (question != null ? !question.equals(poll.question) : poll.question != null) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(options, poll.options)) return false;
        return is_closed != null ? is_closed.equals(poll.is_closed) : poll.is_closed == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Poll{" +
                "id='" + id + '\'' +
                ", question='" + question + '\'' +
                ", options=" + Arrays.toString(options) +
                ", is_closed=" + is_closed +
                '}';
    }
}
