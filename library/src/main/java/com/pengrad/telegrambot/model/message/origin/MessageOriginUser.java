package com.pengrad.telegrambot.model.message.origin;

import com.pengrad.telegrambot.model.User;

import java.util.Objects;

public class MessageOriginUser extends MessageOrigin {

    public static final String MESSAGE_ORIGIN_TYPE = "user";

    private User sender_user;

    public MessageOriginUser() {
        super(MESSAGE_ORIGIN_TYPE);
    }
    public User senderUser() {
        return sender_user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageOriginUser that = (MessageOriginUser) o;
        return Objects.equals(type, that.type)
                && Objects.equals(date, that.date)
                && Objects.equals(sender_user, that.sender_user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, date, sender_user);
    }

    @Override
    public String toString() {
        return "MessageOriginUser{" +
            "type='" + type + "'," +
            "date='" + date + "'," +
            "sender_user='" + sender_user + "'" +
            '}';
    }

}
