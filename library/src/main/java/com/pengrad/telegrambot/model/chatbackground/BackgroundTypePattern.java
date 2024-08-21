package com.pengrad.telegrambot.model.chatbackground;

import java.util.Objects;

import com.pengrad.telegrambot.model.Document;

public class BackgroundTypePattern extends BackgroundType {

    public static final String TYPE = "pattern";

    private Document document;
    private BackgroundFill fill;
    private Integer intensity;
    private Boolean is_inverted;
    private Boolean is_moving;

    public BackgroundTypePattern(Document document, BackgroundFill fill, Integer intensity) {
        super(TYPE);
        this.document = document;
        this.fill = fill;
        this.intensity = intensity;
    }

    public Document document() {
        return document;
    }

    public BackgroundFill fill() {
        return fill;
    }

    public Integer intensity() {
        return intensity;
    }

    public Boolean isInverted() {
        return is_inverted;
    }

    public Boolean isMoving() {
        return is_moving;
    }

    public BackgroundTypePattern isInverted(Boolean isInverted) {
        this.is_inverted = isInverted;
        return this;
    }

    public BackgroundTypePattern isMoving(Boolean isMoving) {
        this.is_moving = isMoving;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        BackgroundTypePattern that = (BackgroundTypePattern) o;
        return Objects.equals(document, that.document) && Objects.equals(fill, that.fill) && Objects.equals(intensity, that.intensity) && Objects.equals(is_inverted, that.is_inverted) && Objects.equals(is_moving, that.is_moving);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), document, fill, intensity, is_inverted, is_moving);
    }

    @Override
    public String toString() {
        return "BackgroundTypePattern{" +
                "document=" + document +
                ", fill=" + fill +
                ", intensity=" + intensity +
                ", is_inverted=" + is_inverted +
                ", is_moving=" + is_moving +
                '}';
    }
}
