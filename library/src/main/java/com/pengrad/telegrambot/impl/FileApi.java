package com.pengrad.telegrambot.impl;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Stas Parshin
 * 16 October 2015
 */
public class FileApi {

    public static final String FILE_API = "https://api.telegram.org/file/bot";

    private final String apiUrl;

    public FileApi(String token) {
        this(FILE_API, token);
    }

    public FileApi(String apiUrl, String token) {
        this.apiUrl = apiUrl + token + "/";
    }

    public String getFullFilePath(String filePath) {
        int slash = filePath.lastIndexOf('/') + 1;
        String path = filePath.substring(0, slash);
        String fileName = filePath.substring(slash);
        try {
            return apiUrl + path + URLEncoder.encode(fileName, "UTF-8").replace("+", "%20");
        } catch (UnsupportedEncodingException e) {
            return apiUrl + filePath;
        }
    }
}
