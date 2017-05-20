package com.pengrad.telegrambot.model.request;

import java.io.Serializable;

/**
 * stas
 * 8/4/15.
 */
public class InlineKeyboardMarkup extends Keyboard implements Serializable {
    private final static long serialVersionUID = 0L;

    private final InlineKeyboardButton[][] inline_keyboard;

    public InlineKeyboardMarkup(InlineKeyboardButton[]... keyboard) {
        this.inline_keyboard = keyboard;
    }
}
