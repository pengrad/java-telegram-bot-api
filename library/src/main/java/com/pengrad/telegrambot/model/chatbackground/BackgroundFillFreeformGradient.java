package com.pengrad.telegrambot.model.chatbackground;

import java.util.Arrays;
import java.util.Objects;

public class BackgroundFillFreeformGradient extends BackgroundFill {

    public static final String TYPE = "freeform_gradient";

    private Integer[] colors;

    public BackgroundFillFreeformGradient(Integer... colors) {
        super(TYPE);
        this.colors = colors;
    }

    public Integer[] colors() {
        return colors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        BackgroundFillFreeformGradient that = (BackgroundFillFreeformGradient) o;
        return Objects.deepEquals(colors, that.colors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), Arrays.hashCode(colors));
    }

    @Override
    public String toString() {
        return "BackgroundFillFreeformGradient{" +
                "colors=" + Arrays.toString(colors) +
                '}';
    }
}
