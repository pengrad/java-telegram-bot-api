package com.pengrad.telegrambot.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * Stas Parshin
 * 06 November 2020
 */
public class MessageId implements Serializable {
    private final static long serialVersionUID = 0L;

    private Integer message_id;

    public Integer messageId() {
        return message_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageId messageId = (MessageId) o;
        return Objects.equals(message_id, messageId.message_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message_id);
    }

    @Override
    public String toString() {
        return "MessageId{" +
                "message_id=" + message_id +
                '}';
    }
}
