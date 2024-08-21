package com.pengrad.telegrambot.model.business;

import com.pengrad.telegrambot.model.Sticker;

import java.util.Objects;

public class BusinessIntro {

    private String title;
    private String message;
    private Sticker sticker;

    public String title() {
        return title;
    }

    public String message() {
        return message;
    }

    public Sticker sticker() {
        return sticker;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BusinessIntro that = (BusinessIntro) o;
        return Objects.equals(title, that.title) && Objects.equals(message, that.message) && Objects.equals(sticker, that.sticker);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, message, sticker);
    }

    @Override
    public String toString() {
        return "BusinessIntro{" +
                "title='" + title + '\'' +
                ", message='" + message + '\'' +
                ", sticker=" + sticker +
                '}';
    }
}
