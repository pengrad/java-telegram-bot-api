package com.pengrad.telegrambot.model;

import java.io.Serializable;
import java.util.Objects;

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
    private String google_place_id;
    private String google_place_type;

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

    public String googlePlaceId() {
        return google_place_id;
    }

    public String googlePlaceType() {
        return google_place_type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Venue venue = (Venue) o;
        return Objects.equals(location, venue.location) &&
                Objects.equals(title, venue.title) &&
                Objects.equals(address, venue.address) &&
                Objects.equals(foursquare_id, venue.foursquare_id) &&
                Objects.equals(foursquare_type, venue.foursquare_type) &&
                Objects.equals(google_place_id, venue.google_place_id) &&
                Objects.equals(google_place_type, venue.google_place_type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(location, title, address, foursquare_id, foursquare_type, google_place_id, google_place_type);
    }

    @Override
    public String toString() {
        return "Venue{" +
                "location=" + location +
                ", title='" + title + '\'' +
                ", address='" + address + '\'' +
                ", foursquare_id='" + foursquare_id + '\'' +
                ", foursquare_type='" + foursquare_type + '\'' +
                ", google_place_id='" + google_place_id + '\'' +
                ", google_place_type='" + google_place_type + '\'' +
                '}';
    }
}
