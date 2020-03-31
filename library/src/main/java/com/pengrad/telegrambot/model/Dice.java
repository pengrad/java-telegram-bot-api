package com.pengrad.telegrambot.model;

import java.io.Serializable;

/**
 * Stas Parshin
 * 31 March 2020
 */
public class Dice implements Serializable {
    private final static long serialVersionUID = 0L;

    private Integer value;

    public Integer value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dice dice = (Dice) o;

        return value != null ? value.equals(dice.value) : dice.value == null;
    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Dice{" +
                "value=" + value +
                '}';
    }
}
