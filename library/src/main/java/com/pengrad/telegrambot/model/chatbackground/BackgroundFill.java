package com.pengrad.telegrambot.model.chatbackground;

import java.util.Objects;

public class BackgroundFill {

    private final String type;

    public BackgroundFill(String type) {
        this.type = type;
    }

    public String type() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BackgroundFill that = (BackgroundFill) o;
        return Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }

    @Override
    public String toString() {
        return "BackgroundFill{" +
            "type='" + type + '\'' +
            '}';
    }
}
