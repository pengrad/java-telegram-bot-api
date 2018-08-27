package com.pengrad.telegrambot.passport;

/**
 * Stas Parshin
 * 28 August 2018
 */
public class PassportElementErrorFiles extends PassportElementError {
    private final static long serialVersionUID = 0L;

    private String[] file_hashes;

    public PassportElementErrorFiles(String type, String[] fileHashes, String message) {
        super("files", type, message);
        file_hashes = fileHashes;
    }
}
