package com.pengrad.telegrambot.passport;

/**
 * Stas Parshin
 * 31 July 2018
 */
public class DataCredentials {

    private String data_hash;
    private String secret;

    public String dataHash() {
        return data_hash;
    }

    public String secret() {
        return secret;
    }

    @Override
    public String toString() {
        return "DataCredentials{" +
                "data_hash='" + data_hash + '\'' +
                ", secret='" + secret + '\'' +
                '}';
    }
}
