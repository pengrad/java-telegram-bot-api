package com.pengrad.telegrambot.model;

/**
 * stas
 * 8/4/15.
 */
public class ReplyKeyboardHide {

    public final boolean hide_keyboard = true;
    public final boolean selective;

    public ReplyKeyboardHide(boolean selective) {
        this.selective = selective;
    }
}
