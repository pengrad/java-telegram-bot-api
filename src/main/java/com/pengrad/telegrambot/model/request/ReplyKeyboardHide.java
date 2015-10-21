package com.pengrad.telegrambot.model.request;

/**
 * stas
 * 8/4/15.
 */
public class ReplyKeyboardHide extends Keyboard {

    public final boolean hide_keyboard = true;
    public final boolean selective;

    public ReplyKeyboardHide() {
        this(false);
    }

    public ReplyKeyboardHide(boolean selective) {
        this.selective = selective;
    }
}
