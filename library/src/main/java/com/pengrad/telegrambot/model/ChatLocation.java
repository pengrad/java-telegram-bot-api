package com.pengrad.telegrambot.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * Stas Parshin
 * 05 November 2020
 */
public class ChatLocation implements Serializable {
    private final static long serialVersionUID = 0L;

    private Location location;
    private String address;

    public Location location() {
        return location;
    }

    public String address() {
        return address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChatLocation that = (ChatLocation) o;
        return Objects.equals(location, that.location) &&
                Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(location, address);
    }

    @Override
    public String toString() {
        return "ChatLocation{" +
                "location=" + location +
                ", address='" + address + '\'' +
                '}';
    }
}
