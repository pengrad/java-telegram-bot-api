package com.pengrad.telegrambot.model.message.origin;

import com.pengrad.telegrambot.model.Chat;

import java.util.Objects;

public class MessageOriginChannel extends MessageOrigin {

    public static final String MESSAGE_ORIGIN_TYPE = "channel";

    private Chat chat;
    private Integer message_id;

    private String author_signature;

    public MessageOriginChannel() {
        super(MESSAGE_ORIGIN_TYPE);
    }

    public Chat chat() {
        return chat;
    }

    public Integer messageId() {
        return message_id;
    }

    public String authorSignature() {
        return author_signature;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageOriginChannel that = (MessageOriginChannel) o;
        return Objects.equals(type, that.type)
                && Objects.equals(date, that.date)
                && Objects.equals(chat, that.chat)
                && Objects.equals(message_id, that.message_id)
                && Objects.equals(author_signature, that.author_signature);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, date, chat, message_id, author_signature);
    }

    @Override
    public String toString() {
        return "MessageOriginChannel{" +
            "type='" + type + "'," +
            "date='" + date + "'," +
            "chat='" + chat + "'," +
            "message_id='" + message_id + "'," +
            "author_signature='" + author_signature + "'" +
            '}';
    }

}
