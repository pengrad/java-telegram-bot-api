package com.pengrad.telegrambot.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * 
 * 18/08/2023.
 */

public class Story implements Serializable {

    private final static long serialVersionUID = 0L;

    private Chat chat;
    private Integer id;

    public Chat chat() {
        return chat;
    }

    public Integer id() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Story story = (Story) o;
        return Objects.equals(chat, story.chat)
            && Objects.equals(id, story.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(chat, id);
    }

    @Override
    public String toString() {
        return "Story{" +
            "chat=" + chat +
            ", id=" + id +
            '}';
    }
}
