package com.pengrad.telegrambot.model;

import java.io.Serializable;

/**
 * Stas Parshin
 * 23 July 2017
 */
public class MaskPosition implements Serializable {
    private final static long serialVersionUID = 0L;

    public enum Point {
        forehead, eyes, mouth, chin
    }

    private String point;
    private Float x_shift, y_shift;
    private Float scale;

    public MaskPosition() {
    }

    public MaskPosition(Point point, Float x_shift, Float y_shift, Float scale) {
        this(point.name(), x_shift, y_shift, scale);
    }

    public MaskPosition(String point, Float xShift, Float yShift, Float scale) {
        this.point = point;
        this.x_shift = xShift;
        this.y_shift = yShift;
        this.scale = scale;
    }

    public String point() {
        return point;
    }

    public Float xShift() {
        return x_shift;
    }

    public Float yShift() {
        return y_shift;
    }

    public Float scale() {
        return scale;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MaskPosition that = (MaskPosition) o;

        if (point != null ? !point.equals(that.point) : that.point != null) return false;
        if (x_shift != null ? !x_shift.equals(that.x_shift) : that.x_shift != null) return false;
        if (y_shift != null ? !y_shift.equals(that.y_shift) : that.y_shift != null) return false;
        return scale != null ? scale.equals(that.scale) : that.scale == null;
    }

    @Override
    public int hashCode() {
        int result = point != null ? point.hashCode() : 0;
        result = 31 * result + (x_shift != null ? x_shift.hashCode() : 0);
        result = 31 * result + (y_shift != null ? y_shift.hashCode() : 0);
        result = 31 * result + (scale != null ? scale.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "MaskPosition{" +
                "point='" + point + '\'' +
                ", x_shift=" + x_shift +
                ", y_shift=" + y_shift +
                ", scale=" + scale +
                '}';
    }
}
