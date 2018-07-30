package com.pengrad.telegrambot.model;

import java.io.Serializable;

/**
 * stas
 * 5/3/16.
 */
public class Venue implements Serializable {
    private final static long serialVersionUID = 0L;

    private Location location;
    private String title;
    private String address;
    private String foursquare_id;
    private String foursquare_type;

    public Location location() {
        return location;
    }

    public String title() {
        return title;
    }

    public String address() {
        return address;
    }

    public String foursquareId() {
        return foursquare_id;
    }

    public String foursquareType() {
        return foursquare_type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Venue venue = (Venue) o;

        if (location != null ? !location.equals(venue.location) : venue.location != null) return false;
        if (title != null ? !title.equals(venue.title) : venue.title != null) return false;
        if (address != null ? !address.equals(venue.address) : venue.address != null) return false;
        if (foursquare_id != null ? !foursquare_id.equals(venue.foursquare_id) : venue.foursquare_id != null) return false;
        return foursquare_type != null ? foursquare_type.equals(venue.foursquare_type) : venue.foursquare_type == null;
    }

    @Override
    public int hashCode() {
        int result = location != null ? location.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (foursquare_id != null ? foursquare_id.hashCode() : 0);
        result = 31 * result + (foursquare_type != null ? foursquare_type.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Venue{" +
                "location=" + location +
                ", title='" + title + '\'' +
                ", address='" + address + '\'' +
                ", foursquare_id='" + foursquare_id + '\'' +
                ", foursquare_type='" + foursquare_type + '\'' +
                '}';
    }
}
