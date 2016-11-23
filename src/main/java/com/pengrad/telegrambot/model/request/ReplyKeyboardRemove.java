package com.pengrad.telegrambot.model.request;

/**
 * Stas Parshin
 * 23 November 2016
 */
public class ReplyKeyboardRemove extends Keyboard {

    private final boolean remove_keyboard = true;
    private final boolean selective;

    public ReplyKeyboardRemove() {
        this(false);
    }

    public ReplyKeyboardRemove(boolean selective) {
        this.selective = selective;
    }

}
