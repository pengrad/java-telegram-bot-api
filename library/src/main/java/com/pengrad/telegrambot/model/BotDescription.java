package com.pengrad.telegrambot.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * Stas Parshin
 * 31 March 2020
 */
public class BotDescription implements Serializable {
    private final static long serialVersionUID = 0L;

    private String description;

    BotDescription() {
    }

    public String description() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BotDescription that = (BotDescription) o;

        return Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return description != null ? description.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "BotDescription{" +
                ", description='" + description + '\'' +
                '}';
    }
}
