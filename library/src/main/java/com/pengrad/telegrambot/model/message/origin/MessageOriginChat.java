package com.pengrad.telegrambot.model.message.origin;

import com.pengrad.telegrambot.model.Chat;

import java.util.Objects;

public class MessageOriginChat extends MessageOrigin {

    public static final String MESSAGE_ORIGIN_TYPE = "chat";

    private Chat sender_chat;
    private String author_signature;

    public MessageOriginChat() {
        super(MESSAGE_ORIGIN_TYPE);
    }
    public Chat senderChat() {
        return sender_chat;
    }

    public String authorSignature() {
        return author_signature;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageOriginChat that = (MessageOriginChat) o;
        return Objects.equals(type, that.type)
                && Objects.equals(date, that.date)
                && Objects.equals(sender_chat, that.sender_chat)
                && Objects.equals(author_signature, that.author_signature);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, date, sender_chat, author_signature);
    }

    @Override
    public String toString() {
        return "MessageOriginChat{" +
            "type='" + type + "'," +
            "date='" + date + "'," +
            "sender_chat='" + sender_chat + "'," +
            "author_signature='" + author_signature + "'" +
            '}';
    }

}
