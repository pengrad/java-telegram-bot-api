package com.pengrad.telegrambot.model.message;

import com.pengrad.telegrambot.model.Chat;

import java.util.Objects;

public class MaybeInaccessibleMessage {

    protected Chat chat;
    protected Integer message_id;
    protected Integer date;

    public Chat chat() {
        return chat;
    }

    public Integer messageId() {
        return message_id;
    }

    public Integer date() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MaybeInaccessibleMessage that = (MaybeInaccessibleMessage) o;
        return Objects.equals(chat, that.chat)
                && Objects.equals(message_id, that.message_id)
                && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(chat, message_id);
    }

    @Override
    public String toString() {
        return "MaybeInaccessibleMessage{" +
            "chat=" + chat +
            ", message_id=" + message_id +
            ", date=" + date +
            '}';
    }
}
