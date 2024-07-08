package com.pengrad.telegrambot.model.message.origin;

import java.io.Serializable;
import java.util.Objects;

public class MessageOrigin implements Serializable  {
    private final static long serialVersionUID = 0L;

    protected String type;
    protected Integer date;

    public MessageOrigin(String type) {
        this.type = type;
    }

    public String type() {
        return type;
    }

    public Integer date() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageOrigin that = (MessageOrigin) o;
        return Objects.equals(type, that.type)
                && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, date);
    }

    @Override
    public String toString() {
        return "MessageOrigin{" +
            "type='" + type + "'," +
            "date='" + date + "'" +
            '}';
    }

}
