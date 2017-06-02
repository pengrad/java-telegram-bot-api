package com.pengrad.telegrambot.model;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Stas Parshin
 * 03 October 2016
 */
public class Game implements Serializable {
    private final static long serialVersionUID = 0L;

    private String title;
    private String description;
    private PhotoSize[] photo;

    private String text;
    private MessageEntity[] text_entities;
    private Animation animation;

    public String title() {
        return title;
    }

    public String description() {
        return description;
    }

    public PhotoSize[] photo() {
        return photo;
    }

    public String text() {
        return text;
    }

    public MessageEntity[] textEntities() {
        return text_entities;
    }

    public Animation animation() {
        return animation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Game game = (Game) o;

        if (title != null ? !title.equals(game.title) : game.title != null) return false;
        if (description != null ? !description.equals(game.description) : game.description != null) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(photo, game.photo)) return false;
        if (text != null ? !text.equals(game.text) : game.text != null) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(text_entities, game.text_entities)) return false;
        return animation != null ? animation.equals(game.animation) : game.animation == null;
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(photo);
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(text_entities);
        result = 31 * result + (animation != null ? animation.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Game{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", photo=" + Arrays.toString(photo) +
                ", text='" + text + '\'' +
                ", text_entities=" + Arrays.toString(text_entities) +
                ", animation=" + animation +
                '}';
    }
}
