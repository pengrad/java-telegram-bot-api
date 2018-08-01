package com.pengrad.telegrambot.passport;

/**
 * Stas Parshin
 * 31 July 2018
 */
public class FileCredentials {

    private String file_hash;
    private String secret;

    public String fileHash() {
        return file_hash;
    }

    public String secret() {
        return secret;
    }

    @Override
    public String toString() {
        return "FileCredentials{" +
                "file_hash='" + file_hash + '\'' +
                ", secret='" + secret + '\'' +
                '}';
    }
}
