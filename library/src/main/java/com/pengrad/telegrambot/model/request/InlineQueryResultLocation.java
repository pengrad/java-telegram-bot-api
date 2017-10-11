package com.pengrad.telegrambot.model.request;

import java.io.Serializable;

/**
 * Stas Parshin
 * 06 May 2016
 */
public class InlineQueryResultLocation extends InlineQueryResult<InlineQueryResultLocation> implements Serializable {
    private final static long serialVersionUID = 0L;

    private float latitude;
    private float longitude;
    private String title;

    private Integer live_period;
    private String thumb_url;
    private Integer thumb_width;
    private Integer thumb_height;

    public InlineQueryResultLocation(String id, float latitude, float longitude, String title) {
        super("location", id);
        this.latitude = latitude;
        this.longitude = longitude;
        this.title = title;
    }

    public InlineQueryResultLocation livePeriod(Integer livePeriod) {
        live_period = livePeriod;
        return this;
    }

    public InlineQueryResultLocation thumbUrl(String thumbUrl) {
        this.thumb_url = thumbUrl;
        return this;
    }

    public InlineQueryResultLocation thumbWidth(Integer thumbWidth) {
        this.thumb_width = thumbWidth;
        return this;
    }

    public InlineQueryResultLocation thumbHeight(Integer thumbHeight) {
        this.thumb_height = thumbHeight;
        return this;
    }
}
