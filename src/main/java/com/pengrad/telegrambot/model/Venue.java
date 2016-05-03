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

        if (!location.equals(venue.location)) return false;
        if (!title.equals(venue.title)) return false;
        if (!address.equals(venue.address)) return false;
        return foursquare_id != null ? foursquare_id.equals(venue.foursquare_id) : venue.foursquare_id == null;

    }

    @Override
    public int hashCode() {
        int result = location.hashCode();
        result = 31 * result + title.hashCode();
        result = 31 * result + address.hashCode();
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
