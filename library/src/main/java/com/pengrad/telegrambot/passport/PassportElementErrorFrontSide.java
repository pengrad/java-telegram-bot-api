package com.pengrad.telegrambot.passport;

/**
 * Stas Parshin
 * 28 August 2018
 */
public class PassportElementErrorFrontSide extends PassportElementErrorAbstractFile {
    private final static long serialVersionUID = 0L;

    public PassportElementErrorFrontSide(String type, String fileHash, String message) {
        super("front_side", type, fileHash, message);
    }
}
