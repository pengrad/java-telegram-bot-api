package com.pengrad.telegrambot.model.request;

import java.io.Serializable;

/**
 * Stas Parshin
 * 06 May 2016
 */
public class InputLocationMessageContent extends InputMessageContent implements Serializable {
    private final static long serialVersionUID = 0L;

    private Float latitude;
    private Float longitude;
    private Integer live_period;

    public InputLocationMessageContent(Float latitude, Float longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public InputLocationMessageContent livePeriod(Integer livePeriod) {
        live_period = livePeriod;
        return this;
    }
}
