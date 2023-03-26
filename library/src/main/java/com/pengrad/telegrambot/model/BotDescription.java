package com.pengrad.telegrambot.model;

import java.io.Serializable;

/**
 * Stas Parshin
 * 31 March 2020
 */
public class BotDescription implements Serializable {
    private final static long serialVersionUID = 0L;

    private String description;

    public BotDescription(String description) {
        this.description = description;
    }

    BotDescription() {}

    public String description() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BotDescription that = (BotDescription) o;

        return description != null ? description.equals(that.description) : that.description == null;
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
