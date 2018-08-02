package com.pengrad.telegrambot.passport;

import java.io.Serializable;

/**
 * Stas Parshin
 * 30 July 2018
 */
public abstract class PassportElementError implements Serializable {
    private final static long serialVersionUID = 0L;

    private final String source;
    private final String type;
    private final String message;

    public PassportElementError(String source, String type, String message) {
        this.source = source;
        this.type = type;
        this.message = message;
    }
}
