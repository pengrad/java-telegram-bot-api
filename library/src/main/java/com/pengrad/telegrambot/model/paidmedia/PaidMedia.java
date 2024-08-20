package com.pengrad.telegrambot.model.paidmedia;

import java.io.Serializable;
import java.util.Objects;

public class PaidMedia implements Serializable {

    private final static long serialVersionUID = 0L;

    private String type;

    public PaidMedia(String type) {
        this.type = type;
    }

    public String type() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PaidMedia that = (PaidMedia) o;
        return Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }

    @Override
    public String toString() {
        return "PaidMedia{" +
                "type='" + type + "'" +
                '}';
    }

}
