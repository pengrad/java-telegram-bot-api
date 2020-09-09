package com.pengrad.telegrambot.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * Stas Parshin
 * 31 March 2020
 */
public class Dice implements Serializable {
    private final static long serialVersionUID = 0L;

    private String emoji;
    private Integer value;

    public String emoji() {
        return emoji;
    }

    public Integer value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dice dice = (Dice) o;

        if (!Objects.equals(emoji, dice.emoji)) return false;
        return Objects.equals(value, dice.value);
    }

    @Override
    public int hashCode() {
        int result = emoji != null ? emoji.hashCode() : 0;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Dice{" +
                "emoji='" + emoji + '\'' +
                ", value=" + value +
                '}';
    }
}
