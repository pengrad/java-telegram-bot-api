package com.pengrad.telegrambot.passport;

/**
 * Stas Parshin
 * 28 August 2018
 */
public class PassportElementErrorFile extends PassportElementErrorAbstractFile {
    private final static long serialVersionUID = 0L;

    public PassportElementErrorFile(String type, String fileHash, String message) {
        super("file", type, fileHash, message);
    }
}
