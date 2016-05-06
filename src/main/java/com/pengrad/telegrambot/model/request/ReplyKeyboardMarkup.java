package com.pengrad.telegrambot.model.request;

/**
 * stas
 * 8/4/15.
 */
public class ReplyKeyboardMarkup extends Keyboard {

    private final KeyboardButton[][] keyboard;
    private boolean resize_keyboard;
    private boolean one_time_keyboard;
    private boolean selective;

    public ReplyKeyboardMarkup(String[]... keyboard) {
        this(keyboard, false, false, false);
    }

    public ReplyKeyboardMarkup(String[][] keyboard, boolean resize_keyboard, boolean one_time_keyboard, boolean selective) {
        KeyboardButton[][] keyboardButtons = new KeyboardButton[keyboard.length][];
        for (int i = 0; i < keyboard.length; i++) {
            keyboardButtons[i] = new KeyboardButton[keyboard[i].length];
            for (int j = 0; j < keyboard[i].length; j++) {
                keyboardButtons[i][j] = new KeyboardButton(keyboard[i][j]);
            }
        }
        this.keyboard = keyboardButtons;
        this.resize_keyboard = resize_keyboard;
        this.one_time_keyboard = one_time_keyboard;
        this.selective = selective;
    }

    public ReplyKeyboardMarkup(KeyboardButton[]... keyboard) {
        this.keyboard = keyboard;
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
