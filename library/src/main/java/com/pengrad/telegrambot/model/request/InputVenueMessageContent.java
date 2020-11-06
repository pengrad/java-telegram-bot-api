package com.pengrad.telegrambot.model.request;

import java.io.Serializable;

/**
 * Stas Parshin
 * 06 May 2016
 */
public class InputVenueMessageContent extends InputMessageContent implements Serializable {
    private final static long serialVersionUID = 0L;

    private Float latitude;
    private Float longitude;
    private String title;
    private String address;
    private String foursquare_id;
    private String foursquare_type;
    private String google_place_id;
    private String google_place_type;

    public InputVenueMessageContent(Float latitude, Float longitude, String title, String address) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.title = title;
        this.address = address;
    }

    public InputVenueMessageContent foursquareId(String foursquareId) {
        this.foursquare_id = foursquareId;
        return this;
    }

    public InputVenueMessageContent foursquareType(String foursquareType) {
        this.foursquare_type = foursquareType;
        return this;
    }

    public InputVenueMessageContent googlePlaceId(String googlePlaceId) {
        this.google_place_id = googlePlaceId;
        return this;
    }

    public InputVenueMessageContent googlePlaceType(String googlePlaceType) {
        this.google_place_type = googlePlaceType;
        return this;
    }
}
