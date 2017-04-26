package com.pengrad.telegrambot.model.request;

import java.io.Serializable;

/**
 * stas
 * 8/4/15.
 */
@Deprecated
public class ReplyKeyboardHide extends Keyboard implements Serializable {
    private final static long serialVersionUID = 0L;

    private final boolean hide_keyboard = true;
    private final boolean selective;

    public ReplyKeyboardHide() {
        this(false);
    }

    public ReplyKeyboardHide(boolean selective) {
        this.selective = selective;
    }
}
