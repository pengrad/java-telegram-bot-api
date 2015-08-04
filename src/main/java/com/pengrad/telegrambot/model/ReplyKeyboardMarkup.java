package com.pengrad.telegrambot.model;

/**
 * stas
 * 8/4/15.
 */
public class ReplyKeyboardMarkup {
    public final String[][] keyboard;

    public ReplyKeyboardMarkup(String[]... keyboard) {
        this.keyboard = keyboard;
    }
}
