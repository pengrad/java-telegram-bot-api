package com.pengrad.telegrambot.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * stas
 * 8/5/15.
 */
public class Location implements Serializable {
    private final static long serialVersionUID = 0L;

    private Float longitude;
    private Float latitude;
    private Float horizontal_accuracy;
    private Integer live_period;
    private Integer heading;
    private Integer proximity_alert_radius;

    public Float longitude() {
        return longitude;
    }

    public Float latitude() {
        return latitude;
    }

    public Float horizontalAccuracy() {
        return horizontal_accuracy;
    }

    public Integer livePeriod() {
        return live_period;
    }

    public Integer heading() {
        return heading;
    }

    public Integer proximityAlertRadius() {
        return proximity_alert_radius;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Objects.equals(longitude, location.longitude) &&
                Objects.equals(latitude, location.latitude) &&
                Objects.equals(horizontal_accuracy, location.horizontal_accuracy) &&
                Objects.equals(live_period, location.live_period) &&
                Objects.equals(heading, location.heading) &&
                Objects.equals(proximity_alert_radius, location.proximity_alert_radius);
    }

    @Override
    public int hashCode() {
        return Objects.hash(longitude, latitude, horizontal_accuracy, live_period, heading, proximity_alert_radius);
    }

    @Override
    public String toString() {
        return "Location{" +
                "longitude=" + longitude +
                ", latitude=" + latitude +
                ", horizontal_accuracy=" + horizontal_accuracy +
                ", live_period=" + live_period +
                ", heading=" + heading +
                ", proximity_alert_radius=" + proximity_alert_radius +
                '}';
    }
}
