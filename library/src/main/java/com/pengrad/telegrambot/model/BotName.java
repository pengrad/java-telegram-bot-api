package com.pengrad.telegrambot.model;

import java.io.Serializable;
import java.util.Objects;

public class BotName implements Serializable {
    private final static long serialVersionUID = 0L;

    private String name;

    BotName() {
    }

    public String name() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BotName that = (BotName) o;

        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "BotName{" +
                ", name='" + name + '\'' +
                '}';
    }
}
