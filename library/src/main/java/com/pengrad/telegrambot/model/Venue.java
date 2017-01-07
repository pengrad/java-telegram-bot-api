package com.pengrad.telegrambot.model;

/**
 * stas
 * 5/3/16.
 */
public class Venue {

    private Location location;
    private String title;
    private String address;
    private String foursquare_id;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Venue venue = (Venue) o;

        if (location != null ? !location.equals(venue.location) : venue.location != null) return false;
        if (title != null ? !title.equals(venue.title) : venue.title != null) return false;
        if (address != null ? !address.equals(venue.address) : venue.address != null) return false;
        return foursquare_id != null ? foursquare_id.equals(venue.foursquare_id) : venue.foursquare_id == null;

    }

    @Override
    public int hashCode() {
        int result = location != null ? location.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (foursquare_id != null ? foursquare_id.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Venue{" +
                "location=" + location +
                ", title='" + title + '\'' +
                ", address='" + address + '\'' +
                ", foursquare_id='" + foursquare_id + '\'' +
                '}';
    }
}
