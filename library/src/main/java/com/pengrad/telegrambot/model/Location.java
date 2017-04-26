package com.pengrad.telegrambot.model;

import java.io.Serializable;

/**
 * stas
 * 8/5/15.
 */
public class Location implements Serializable {
    private final static long serialVersionUID = 0L;

    private Float longitude;
    private Float latitude;

    public Float longitude() {
        return longitude;
    }

    public Float latitude() {
        return latitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Location location = (Location) o;

        if (longitude != null ? !longitude.equals(location.longitude) : location.longitude != null) return false;
        return latitude != null ? latitude.equals(location.latitude) : location.latitude == null;
    }

    @Override
    public int hashCode() {
        int result = longitude != null ? longitude.hashCode() : 0;
        result = 31 * result + (latitude != null ? latitude.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Location{" +
                "longitude=" + longitude +
                ", latitude=" + latitude +
                '}';
    }
}
