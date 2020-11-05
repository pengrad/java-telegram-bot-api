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
    private Float horizontal_accuracy;
    private Integer live_period;
    private Integer heading;
    private Integer proximity_alert_radius;

    public InputLocationMessageContent(Float latitude, Float longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public InputLocationMessageContent horizontalAccuracy(float horizontalAccuracy) {
        horizontal_accuracy = horizontalAccuracy;
        return this;
    }

    public InputLocationMessageContent livePeriod(Integer livePeriod) {
        live_period = livePeriod;
        return this;
    }

    public InputLocationMessageContent heading(int heading) {
        this.heading = heading;
        return this;
    }

    public InputLocationMessageContent proximityAlertRadius(int proximityAlertRadius) {
        proximity_alert_radius = proximityAlertRadius;
        return this;
    }
}
