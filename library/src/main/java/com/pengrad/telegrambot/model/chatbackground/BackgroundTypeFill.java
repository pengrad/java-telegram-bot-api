package com.pengrad.telegrambot.model.chatbackground;

import java.util.Objects;

public class BackgroundTypeFill extends BackgroundType {

    public static final String TYPE = "fill";

    private BackgroundFill fill;
    private Integer dark_theme_dimming;

    public BackgroundTypeFill(BackgroundFill fill, Integer darkThemeDimming) {
        super(TYPE);
        this.fill = fill;
        this.dark_theme_dimming = darkThemeDimming;
    }

    public BackgroundFill fill() {
        return fill;
    }

    public Integer darkThemeDimming() {
        return dark_theme_dimming;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        BackgroundTypeFill that = (BackgroundTypeFill) o;
        return Objects.equals(fill, that.fill) && Objects.equals(dark_theme_dimming, that.dark_theme_dimming);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), fill, dark_theme_dimming);
    }

    @Override
    public String toString() {
        return "BackgroundTypeFill{" +
                "type='" + type() + '\'' +
                ", fill='" + fill + '\'' +
                ", dark_theme_dimming=" + dark_theme_dimming +
                '}';
    }
}
