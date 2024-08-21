package com.pengrad.telegrambot.model.chatbackground;

import java.util.Objects;

import com.pengrad.telegrambot.model.Document;

public class BackgroundTypeWallpaper extends BackgroundType {

    public static final String TYPE = "wallpaper";

    private Document document;
    private Integer dark_theme_dimming;
    private Boolean is_blurred;
    private Boolean is_moving;

    public BackgroundTypeWallpaper(Document document, Integer darkThemeDimming) {
        super(TYPE);
        this.document = document;
        this.dark_theme_dimming = darkThemeDimming;
    }

    public Document document() {
        return document;
    }

    public Integer darkThemeDimming() {
        return dark_theme_dimming;
    }

    public Boolean isBlurred() {
        return is_blurred;
    }

    public Boolean isMoving() {
        return is_moving;
    }

    public BackgroundTypeWallpaper isBlurred(Boolean isBlurred) {
        this.is_blurred = isBlurred;
        return this;
    }

    public BackgroundTypeWallpaper isMoving(Boolean isMoving) {
        this.is_moving = isMoving;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        BackgroundTypeWallpaper that = (BackgroundTypeWallpaper) o;
        return Objects.equals(document, that.document) && Objects.equals(dark_theme_dimming, that.dark_theme_dimming) && Objects.equals(is_blurred, that.is_blurred) && Objects.equals(is_moving, that.is_moving);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), document, dark_theme_dimming, is_blurred, is_moving);
    }

    @Override
    public String toString() {
        return "BackgroundTypeWallpaper{" +
                "type='" + type() + '\'' +
                ", document='" + document + '\'' +
                ", dark_theme_dimming=" + dark_theme_dimming +
                ", is_blurred=" + is_blurred +
                ", is_moving=" + is_moving +
                '}';
    }
}
