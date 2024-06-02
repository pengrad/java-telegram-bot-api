package com.pengrad.telegrambot.model.chatbackground;

import java.io.Serializable;
import java.util.Objects;


public class ChatBackground implements Serializable {

    private final static long serialVersionUID = 0L;

    private BackgroundType type;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChatBackground that = (ChatBackground) o;

        return Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }

    @Override
    public String toString() {
        return "ChatBackground{" +
                "type=" + type +
                '}';
    }

}
