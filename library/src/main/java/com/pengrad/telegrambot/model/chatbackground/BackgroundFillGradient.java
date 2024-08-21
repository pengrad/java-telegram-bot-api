package com.pengrad.telegrambot.model.chatbackground;

import java.util.Objects;

public class BackgroundFillGradient extends BackgroundFill {

    public static final String TYPE = "gradient";

    private Integer top_color;
    private Integer bottom_color;
    private Integer rotation_angle;

    public BackgroundFillGradient(Integer topColor, Integer bottomColor, Integer rotationAngle) {
        super(TYPE);
        this.top_color = topColor;
        this.bottom_color = bottomColor;
        this.rotation_angle = rotationAngle;
    }

    public Integer topColor() {
        return top_color;
    }

    public Integer bottomColor() {
        return bottom_color;
    }

    public Integer rotationAngle() {
        return rotation_angle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        BackgroundFillGradient that = (BackgroundFillGradient) o;
        return Objects.equals(top_color, that.top_color) && Objects.equals(bottom_color, that.bottom_color) && Objects.equals(rotation_angle, that.rotation_angle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), top_color, bottom_color, rotation_angle);
    }

    @Override
    public String toString() {
        return "BackgroundFillGradient{" +
                "type='" + type() + '\'' +
                ", top_color=" + top_color +
                ", bottom_color=" + bottom_color +
                ", rotation_angle=" + rotation_angle +
                '}';
    }
}
