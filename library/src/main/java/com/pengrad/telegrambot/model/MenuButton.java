package com.pengrad.telegrambot.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * Mirco Ianese
 * 20 Apr 2022
 */
public class MenuButton implements Serializable {

    private final static long serialVersionUID = 0L;

    private String type;

    public MenuButton(String type) {
        this.type = type;
    }

    MenuButton() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuButton that = (MenuButton) o;
        return Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }

    @Override
    public String toString() {
        return "MenuButton{" +
                "type='" + type + '\'' +
                '}';
    }
}
