package com.pengrad.telegrambot.model.request;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * stas
 * 8/4/15.
 */
public class ReplyKeyboardMarkup extends Keyboard implements Serializable {
    private final static long serialVersionUID = 0L;

    private final List<List<KeyboardButton>> keyboard;
    private boolean resize_keyboard;
    private boolean one_time_keyboard;
    private boolean selective;

    public ReplyKeyboardMarkup(boolean resize_keyboard, boolean one_time_keyboard, boolean selective) {
        this.keyboard = new ArrayList<>();
        this.resize_keyboard = resize_keyboard;
        this.one_time_keyboard = one_time_keyboard;
        this.selective = selective;
    }

    public ReplyKeyboardMarkup() {
        this(false,false,false);
    }

    public static ReplyKeyboardMarkup create(String... firstLine) {
        return new ReplyKeyboardMarkup().addRow(firstLine);
    }

    public static ReplyKeyboardMarkup create(KeyboardButton... firstLine) {
        return new ReplyKeyboardMarkup().addRow(firstLine);
    }

    public ReplyKeyboardMarkup(String[]... keyboard) {
        this();
        for (String[] row : keyboard) {
            addRow(row);
        }
    }

    public ReplyKeyboardMarkup(KeyboardButton[]... keyboard) {
        this();
        for (KeyboardButton[] row : keyboard) {
            addRow(row);
        }
    }

    public ReplyKeyboardMarkup addRow(KeyboardButton... buttons) {
        this.keyboard.add(Arrays.asList(buttons));
        return this;
    }

    public ReplyKeyboardMarkup addRow(String... buttons) {
        List<KeyboardButton> newRow = new ArrayList<>();
        for(String button: buttons) {
            newRow.add(new KeyboardButton(button));
        }
        this.keyboard.add(newRow);
        return this;
    }

    @Deprecated
    public ReplyKeyboardMarkup(String[][] keyboard, boolean resize_keyboard, boolean one_time_keyboard, boolean selective) {
        this(resize_keyboard,one_time_keyboard,selective);
        for (String[] line : keyboard) {
            addRow(line);
        }
    }

    public ReplyKeyboardMarkup resizeKeyboard(boolean resizeKeyboard) {
        this.resize_keyboard = resizeKeyboard;
        return this;
    }

    public ReplyKeyboardMarkup oneTimeKeyboard(boolean oneTimeKeyboard) {
        this.one_time_keyboard = oneTimeKeyboard;
        return this;
    }

    public ReplyKeyboardMarkup selective(boolean selective) {
        this.selective = selective;
        return this;
    }
}
