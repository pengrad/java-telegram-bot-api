package com.pengrad.telegrambot.model.request;

/**
 * Stas Parshin
 * 06 May 2016
 */
public class InlineQueryResultVenue extends InlineQueryResult<InlineQueryResultVenue> {

    private float latitude;
    private float longitude;
    private String title;
    private String address;

    private String foursquare_id;
    private String thumb_url;
    private Integer thumb_width;
    private Integer thumb_height;

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

    public InlineQueryResultVenue thumbUrl(String thumbUrl) {
        this.thumb_url = thumbUrl;
        return this;
    }

    public InlineQueryResultVenue thumbWidth(Integer thumbWidth) {
        this.thumb_width = thumbWidth;
        return this;
    }

    public InlineQueryResultVenue thumbHeight(Integer thumbHeight) {
        this.thumb_height = thumbHeight;
        return this;
    }
}
