package com.pengrad.telegrambot.model.request;

import com.pengrad.telegrambot.model.*;

import java.io.Serializable;

/**
 * Stas Parshin
 * 25 January 2020
 */
public class KeyboardButtonPollType implements Serializable {
    private final static long serialVersionUID = 0L;

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
