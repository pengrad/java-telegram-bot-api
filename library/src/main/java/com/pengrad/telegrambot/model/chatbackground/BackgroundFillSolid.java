package com.pengrad.telegrambot.model.chatbackground;

import java.util.Objects;

public class BackgroundFillSolid extends BackgroundFill {

    public static final String TYPE = "solid";

    private Integer color;

    public BackgroundFillSolid(Integer color) {
        super(TYPE);
        this.color = color;
    }

    public Integer color() {
        return color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        BackgroundFillSolid that = (BackgroundFillSolid) o;
        return Objects.equals(color, that.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), color);
    }

    @Override
    public String toString() {
        return "BackgroundFillSolid{" +
                "type='" + type() + '\'' +
                ", color=" + color +
                '}';
    }
}
