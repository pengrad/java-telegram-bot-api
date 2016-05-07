package com.pengrad.telegrambot.model.request;

/**
 * Stas Parshin
 * 06 May 2016
 */
public class InputContactMessageContent extends InputMessageContent {

    private String phone_number;
    private String first_name;
    private String last_name;

    public InputContactMessageContent(String phoneNumber, String firstName) {
        this.phone_number = phoneNumber;
        this.first_name = firstName;
    }

    public InputContactMessageContent lastName(String lastName) {
        this.last_name = lastName;
        return this;
    }
}
