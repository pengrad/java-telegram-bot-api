package com.pengrad.telegrambot.passport;

/**
 * Stas Parshin
 * 28 August 2018
 */
public class PassportElementErrorTranslationFiles extends PassportElementError {
    private final static long serialVersionUID = 0L;

    private String[] file_hashes;

    public PassportElementErrorTranslationFiles(String type, String[] fileHashes, String message) {
        super("translation_files", type, message);
        file_hashes = fileHashes;
    }
}
