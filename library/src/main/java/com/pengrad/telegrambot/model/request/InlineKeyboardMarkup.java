package com.pengrad.telegrambot.model.request;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * stas
 * 8/4/15.
 */
public class InlineKeyboardMarkup extends Keyboard implements Serializable {
    private final static long serialVersionUID = 0L;

    private final List<List<InlineKeyboardButton>> inline_keyboard;

    public InlineKeyboardMarkup() {
        this.inline_keyboard = new ArrayList<>();
    }

    public InlineKeyboardMarkup(InlineKeyboardButton[]... keyboard) {
        this();
        for (InlineKeyboardButton[] row : keyboard) {
            addRow(row);
        }
    }

    public InlineKeyboardMarkup(InlineKeyboardButton... keyboard) {
        this(new InlineKeyboardButton[][]{keyboard});
    }

    public InlineKeyboardMarkup addRow(InlineKeyboardButton... keyboard) {
        this.inline_keyboard.add(Arrays.asList(keyboard));
        return this;
    }

    public InlineKeyboardButton[][] inlineKeyboard() {
        InlineKeyboardButton[][] res = new InlineKeyboardButton[inline_keyboard.size()][];
        for (int i = 0; i < inline_keyboard.size(); i++) {
            List<InlineKeyboardButton> line = inline_keyboard.get(i);
            res[i] = line.toArray(new InlineKeyboardButton[]{});
        }
        return res;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InlineKeyboardMarkup that = (InlineKeyboardMarkup) o;
        return Objects.equals(inline_keyboard, that.inline_keyboard);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inline_keyboard);
    }

    @Override
    public String toString() {
        return "InlineKeyboardMarkup{" +
                "inline_keyboard=" + inline_keyboard +
                '}';
    }
}
