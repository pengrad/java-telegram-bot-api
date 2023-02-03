package com.pengrad.telegrambot.model;

import java.io.Serializable;
import java.util.Objects;

public class ForumTopicEdited implements Serializable {
    private final static long serialVersionUID = 0L;

    private String name;
    private String icon_custom_emoji_id;

    public String name() {
        return name;
    }

    public String iconCustomEmojiId() {
        return icon_custom_emoji_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ForumTopicEdited that = (ForumTopicEdited) o;

        return Objects.equals(name, that.name) &&
                Objects.equals(icon_custom_emoji_id, that.icon_custom_emoji_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name,
                icon_custom_emoji_id);
    }

    @Override
    public String toString() {
        return "ForumTopicEdited{" +
                "name='" + name + '\'' +
                ", icon_custom_emoji_id='" + icon_custom_emoji_id + '\'' +
                '}';
    }
}
