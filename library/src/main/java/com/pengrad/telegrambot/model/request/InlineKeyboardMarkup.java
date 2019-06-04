package com.pengrad.telegrambot.model.request;

import java.io.Serializable;
import java.util.Arrays;

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

    public InlineKeyboardButton[][] inlineKeyboard() {
        return inline_keyboard;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InlineKeyboardMarkup that = (InlineKeyboardMarkup) o;

        return Arrays.deepEquals(inline_keyboard, that.inline_keyboard);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(inline_keyboard);
    }
}
