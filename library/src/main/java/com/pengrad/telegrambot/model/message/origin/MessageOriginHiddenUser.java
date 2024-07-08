package com.pengrad.telegrambot.model.message.origin;

import java.util.Objects;

public class MessageOriginHiddenUser extends MessageOrigin {

    public static final String MESSAGE_ORIGIN_TYPE = "hidden_user";

    private String sender_user_name;

    public MessageOriginHiddenUser() {
        super(MESSAGE_ORIGIN_TYPE);
    }

    public String senderUserName() {
        return sender_user_name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageOriginHiddenUser that = (MessageOriginHiddenUser) o;
        return Objects.equals(type, that.type)
                && Objects.equals(date, that.date)
                && Objects.equals(sender_user_name, that.sender_user_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, date, sender_user_name);
    }

    @Override
    public String toString() {
        return "MessageOriginHiddenUser{" +
            "type='" + type + "'," +
            "date='" + date + "'," +
            "sender_user_name='" + sender_user_name + "'" +
            '}';
    }

}
