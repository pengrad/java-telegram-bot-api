package com.pengrad.telegrambot.passport;

/**
 * Stas Parshin
 * 28 August 2018
 */
public class PassportElementErrorUnspecified extends PassportElementError {
    private final static long serialVersionUID = 0L;

    private String element_hash;

    public PassportElementErrorUnspecified(String type, String elementHash, String message) {
        super("unspecified", type, message);
        element_hash = elementHash;
    }
}
