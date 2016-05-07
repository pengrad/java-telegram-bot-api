package com.pengrad.telegrambot.model.request;

/**
 * Stas Parshin
 * 06 May 2016
 */
public class InputLocationMessageContent extends InputMessageContent {

    private Float latitude;
    private Float longitude;

    public InputLocationMessageContent(Float latitude, Float longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
