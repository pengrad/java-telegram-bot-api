package com.pengrad.telegrambot.passport;

import java.util.Arrays;

/**
 * Stas Parshin
 * 31 July 2018
 */
public class SecureValue {

    private DataCredentials data;
    private FileCredentials front_side;
    private FileCredentials reverse_side;
    private FileCredentials selfie;
    private FileCredentials[] files;

    public DataCredentials data() {
        return data;
    }

    public FileCredentials frontSide() {
        return front_side;
    }

    public FileCredentials reverseSide() {
        return reverse_side;
    }

    public FileCredentials selfie() {
        return selfie;
    }

    public FileCredentials[] files() {
        return files;
    }

    @Override
    public String toString() {
        return "SecureValue{" +
                "data=" + data +
                ", front_side=" + front_side +
                ", reverse_side=" + reverse_side +
                ", selfie=" + selfie +
                ", files=" + Arrays.toString(files) +
                '}';
    }
}
