package com.pengrad.telegrambot.model;

import java.io.Serializable;

/**
 * Stas Parshin
 * 31 March 2020
 */
public class BotShortDescription implements Serializable {
    private final static long serialVersionUID = 0L;

    private String short_description;

    public BotShortDescription(String shortDescription) {
        this.short_description = shortDescription;
    }

    BotShortDescription() {}

    public String shortDescription() {
        return short_description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BotShortDescription that = (BotShortDescription) o;

        return short_description != null ? short_description.equals(that.short_description) : that.short_description == null;
    }

    @Override
    public int hashCode() {
        return short_description != null ? short_description.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "BotShortDescription{" +
                ", short_description='" + short_description + '\'' +
                '}';
    }
}
