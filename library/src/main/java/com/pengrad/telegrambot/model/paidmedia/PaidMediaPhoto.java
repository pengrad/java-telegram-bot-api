package com.pengrad.telegrambot.model.paidmedia;

import com.pengrad.telegrambot.model.PhotoSize;

import java.util.Arrays;
import java.util.Objects;

public class PaidMediaPhoto extends PaidMedia {

    public final static String TYPE = "photo";

    private PhotoSize[] photo;

    public PaidMediaPhoto() {
        super(TYPE);
    }

    public PhotoSize[] getPhoto() {
        return photo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaidMediaPhoto that = (PaidMediaPhoto) o;
        return Objects.equals(type(), that.type()) &&
                Arrays.equals(photo, that.photo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type(), photo);
    }

    @Override
    public String toString() {
        return "PaidMediaPhoto{" +
                "type='" + type() + "\'," +
                ", photo=" + Arrays.toString(photo) + "\'" +
                '}';
    }

}
