package com.pengrad.telegrambot.model.request;

/**
 * stas
 * 8/4/15.
 */
public class InlineKeyboardMarkup extends Keyboard {

    private final InlineKeyboardButton[][] inline_keyboard;

    public InlineKeyboardMarkup(InlineKeyboardButton[]... keyboard) {
        this.inline_keyboard = keyboard;
    }
}
