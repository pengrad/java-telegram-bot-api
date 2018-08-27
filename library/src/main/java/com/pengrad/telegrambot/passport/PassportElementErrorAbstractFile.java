package com.pengrad.telegrambot.passport;

/**
 * Stas Parshin
 * 28 August 2018
 */
abstract class PassportElementErrorAbstractFile extends PassportElementError {
    private final static long serialVersionUID = 0L;

    private final String file_hash;

    public PassportElementErrorAbstractFile(String source, String type, String fileHash, String message) {
        super(source, type, message);
        file_hash = fileHash;
    }
}
