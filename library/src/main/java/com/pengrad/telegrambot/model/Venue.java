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

        if (!Objects.equals(location, venue.location)) return false;
        if (!Objects.equals(title, venue.title)) return false;
        if (!Objects.equals(address, venue.address)) return false;
        if (!Objects.equals(foursquare_id, venue.foursquare_id)) return false;
        return Objects.equals(foursquare_type, venue.foursquare_type);
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
