package com.pengrad.telegrambot.model.reaction;

import java.io.Serializable;
import java.util.Objects;

public class ReactionType implements Serializable {
    private final static long serialVersionUID = 0L;

    private final String type;

    public ReactionType(String type) {
        this.type = type;
    }

    public String type() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReactionType that = (ReactionType) o;
        return Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }

    @Override
    public String toString() {
        return "ReactionType{" +
                "type='" + type + '\'' +
                '}';
    }
}
