package com.pengrad.telegrambot.passport;

/**
 * Stas Parshin
 * 31 July 2018
 */
public class Credentials {

    private SecureData secure_data;
    private String payload;

    public SecureData secureData() {
        return secure_data;
    }

    public String payload() {
        return payload;
    }

    @Override
    public String toString() {
        return "Credentials{" +
                "secure_data=" + secure_data +
                ", payload='" + payload + '\'' +
                '}';
    }
}
