package com.pengrad.telegrambot.model;

import java.io.Serializable;
import java.util.Objects;

public class TextQuote implements Serializable {

    private final static long serialVersionUID = 0L;

    private String text;
    private MessageEntity[] entities;
    private Integer position;
    private Boolean is_manual;

    public String text() {
        return text;
    }

    public MessageEntity[] entities() {
        return entities;
    }

    public Integer position() {
        return position;
    }

    public Boolean isManual() {
        return is_manual;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TextQuote that = (TextQuote) o;
        return Objects.equals(text, that.text) &&
                Objects.equals(entities, that.entities) &&
                Objects.equals(position, that.position) &&
                Objects.equals(is_manual, that.is_manual);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, entities, position, is_manual);
    }

    @Override
    public String toString() {
        return "TextQuote{" +
                "text='" + text + "'," +
                "entities='" + entities + "'," +
                "position='" + position + "'," +
                "is_manual='" + is_manual + "'" +
                '}';
    }

}
