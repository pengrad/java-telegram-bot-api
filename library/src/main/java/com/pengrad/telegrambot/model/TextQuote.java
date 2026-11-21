package com.pengrad.telegrambot.model;

import com.pengrad.telegrambot.model.richmessages.richtext.RichText;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

public class TextQuote implements Serializable {

    private final static long serialVersionUID = 0L;

    private String text;
    private MessageEntity[] entities;
    private RichText[] rich_texts;
    private Integer position;
    private Boolean is_manual;

    public String text() {
        return text;
    }

    public MessageEntity[] entities() {
        return entities;
    }

    public RichText[] richTexts() {
        return rich_texts;
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
        return Objects.equals(text, textQuote.text) && Arrays.equals(entities, textQuote.entities) && Arrays.equals(rich_texts, textQuote.rich_texts) && Objects.equals(position, textQuote.position) && Objects.equals(is_manual, textQuote.is_manual);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(text, position, is_manual);
        result = 31 * result + Arrays.hashCode(entities);
        result = 31 * result + Arrays.hashCode(rich_texts);
        return result;
    }

    @Override
    public String toString() {
        return "TextQuote{" +
                "text='" + text + '\'' +
                ", entities=" + Arrays.toString(entities) +
                ", rich_texts=" + Arrays.toString(rich_texts) +
                ", position=" + position +
                ", is_manual=" + is_manual +
                '}';
    }
}
