package com.pengrad.telegrambot.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * Stas Parshin
 * 10 March 2021
 */
public class MessageAutoDeleteTimerChanged implements Serializable {
    private final static long serialVersionUID = 0L;

    private Integer message_auto_delete_time;

    public Integer messageAutoDeleteTime() {
        return message_auto_delete_time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageAutoDeleteTimerChanged that = (MessageAutoDeleteTimerChanged) o;
        return Objects.equals(message_auto_delete_time, that.message_auto_delete_time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message_auto_delete_time);
    }

    @Override
    public String toString() {
        return "MessageAutoDeleteTimerChanged{" +
                "message_auto_delete_time=" + message_auto_delete_time +
                '}';
    }
}
