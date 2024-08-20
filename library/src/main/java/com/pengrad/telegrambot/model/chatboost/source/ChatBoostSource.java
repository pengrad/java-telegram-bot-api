package com.pengrad.telegrambot.model.chatboost.source;

import java.io.Serializable;
import java.util.Objects;

import com.pengrad.telegrambot.model.User;


public class ChatBoostSource implements Serializable {
    private final static long serialVersionUID = 0L;

    protected String source;
    protected User user;

    ChatBoostSource() {
    }

    public ChatBoostSource(String source) {
        this.source = source;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ChatBoostSource that = (ChatBoostSource) o;
        return Objects.equals(source, that.source)
                && Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(source, user);
    }

    @Override
    public String toString() {
        return "ChatBoostSource{" +
                "source='" + source + "'," +
                "user='" + user + "'" +
                '}';
    }
}
