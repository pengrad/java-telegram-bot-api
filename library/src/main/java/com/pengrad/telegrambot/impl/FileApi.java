package com.pengrad.telegrambot.impl;

/**
 * Stas Parshin
 * 16 October 2015
 */
public class FileApi {

    public static final String FILE_API = "https://api.telegram.org/file/bot";

    private final String apiUrl;

    public FileApi(String token) {
        this.apiUrl = FILE_API + token + "/";
    }

    public String getFullFilePath(String filePath) {
        return apiUrl + filePath;
    }
}
