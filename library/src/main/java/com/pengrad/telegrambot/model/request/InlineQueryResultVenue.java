package com.pengrad.telegrambot.model.request;

import java.io.Serializable;

/**
 * Stas Parshin
 * 06 May 2016
 */
public class InlineQueryResultVenue extends InlineQueryResult<InlineQueryResultVenue> implements Serializable {
    private final static long serialVersionUID = 0L;

    private float latitude;
    private float longitude;
    private String title;
    private String address;

    private String foursquare_id;
    private String foursquare_type;
    private String google_place_id;
    private String google_place_type;

    private String thumbnail_url;
    private Integer thumbnail_width;
    private Integer thumbnail_height;

    public InlineQueryResultVenue(String id, float latitude, float longitude, String title, String address) {
        super("venue", id);
        this.latitude = latitude;
        this.longitude = longitude;
        this.title = title;
        this.address = address;
    }

    public InlineQueryResultVenue foursquareId(String foursquareId) {
        this.foursquare_id = foursquareId;
        return this;
    }

    public InlineQueryResultVenue foursquareType(String foursquareType) {
        this.foursquare_type = foursquareType;
        return this;
    }

    public InlineQueryResultVenue googlePlaceId(String googlePlaceId) {
        this.google_place_id = googlePlaceId;
        return this;
    }

    public InlineQueryResultVenue googlePlaceType(String googlePlaceType) {
        this.google_place_type = googlePlaceType;
        return this;
    }

    /**
     * @deprecated Use thumbnailUrl instead
     */
    @Deprecated
    public InlineQueryResultVenue thumbUrl(String thumbUrl) {
        return thumbnailUrl(thumbUrl);
    }

    /**
     * @deprecated Use thumbnailWidth instead
     */
    @Deprecated
    public InlineQueryResultVenue thumbWidth(Integer thumbWidth) {
        return thumbnailWidth(thumbWidth);
    }

    /**
     * @deprecated Use thumbnailHeight instead
     */
    @Deprecated    
    public InlineQueryResultVenue thumbHeight(Integer thumbHeight) {
        return thumbnailHeight(thumbHeight);
    }


    public InlineQueryResultVenue thumbnailUrl(String thumbnailUrl) {
        this.thumbnail_url = thumbnailUrl;
        return this;
    }

    public InlineQueryResultVenue thumbnailWidth(Integer thumbnailWidth) {
        this.thumbnail_width = thumbnailWidth;
        return this;
    }

    public InlineQueryResultVenue thumbnailHeight(Integer thumbnailHeight) {
        this.thumbnail_height = thumbnailHeight;
        return this;
    }
}
