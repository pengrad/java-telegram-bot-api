package com.pengrad.telegrambot.model;

import java.io.Serializable;
import java.util.Arrays;
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
        TextQuote textQuote = (TextQuote) o;
        return Objects.equals(text, textQuote.text) && Arrays.equals(entities, textQuote.entities) && Objects.equals(position, textQuote.position) && Objects.equals(is_manual, textQuote.is_manual);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(text, position, is_manual);
        result = 31 * result + Arrays.hashCode(entities);
        return result;
    }

    @Override
    public String toString() {
        return "TextQuote{" +
                "text='" + text + '\'' +
                ", entities=" + Arrays.toString(entities) +
                ", position=" + position +
                ", is_manual=" + is_manual +
                '}';
    }
}
