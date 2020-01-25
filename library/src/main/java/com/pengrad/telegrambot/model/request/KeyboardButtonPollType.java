package com.pengrad.telegrambot.model.request;

import com.pengrad.telegrambot.model.*;

/**
 * Stas Parshin
 * 25 January 2020
 */
public class KeyboardButtonPollType {

    private String type;

    public KeyboardButtonPollType() {
    }

    public KeyboardButtonPollType(String type) {
        this.type = type;
    }

    public KeyboardButtonPollType(Poll.Type type) {
        this(type.name());
    }
}
