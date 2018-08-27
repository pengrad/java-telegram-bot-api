package com.pengrad.telegrambot.passport;

/**
 * Stas Parshin
 * 28 August 2018
 */
public class PassportElementErrorTranslationFile extends PassportElementErrorAbstractFile {
    private final static long serialVersionUID = 0L;

    public PassportElementErrorTranslationFile(String type, String fileHash, String message) {
        super("translation_file", type, fileHash, message);
    }
}
