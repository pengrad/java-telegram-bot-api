package com.pengrad.telegrambot.passport;

/**
 * Stas Parshin
 * 28 August 2018
 */
public class PassportElementErrorReverseSide extends PassportElementErrorAbstractFile {
    private final static long serialVersionUID = 0L;

    public PassportElementErrorReverseSide(String type, String fileHash, String message) {
        super("reverse_side", type, fileHash, message);
    }
}
