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

    private Float horizontal_accuracy;
    private Integer live_period;
    private Integer heading;
    private Integer proximity_alert_radius;

    private String thumbnail_url;
    private Integer thumbnail_width;
    private Integer thumbnail_height;

    public InlineQueryResultLocation(String id, float latitude, float longitude, String title) {
        super("location", id);
        this.latitude = latitude;
        this.longitude = longitude;
        this.title = title;
    }

    public InlineQueryResultLocation horizontalAccuracy(float horizontalAccuracy) {
        horizontal_accuracy = horizontalAccuracy;
        return this;
    }

    public InlineQueryResultLocation livePeriod(Integer livePeriod) {
        live_period = livePeriod;
        return this;
    }

    public InlineQueryResultLocation heading(int heading) {
        this.heading = heading;
        return this;
    }

    public InlineQueryResultLocation proximityAlertRadius(int proximityAlertRadius) {
        proximity_alert_radius = proximityAlertRadius;
        return this;
    }

    /**
     * @deprecated Use thumbnailUrl instead
     */
    @Deprecated
    public InlineQueryResultLocation thumbUrl(String thumbUrl) {
        return thumbnailUrl(thumbUrl);
    }

    /**
     * @deprecated Use thumbnailWidth instead
     */
    @Deprecated
    public InlineQueryResultLocation thumbWidth(Integer thumbWidth) {
        return thumbnailWidth(thumbWidth);
    }

    /**
     * @deprecated Use thumbnailHeight instead
     */
    @Deprecated
    public InlineQueryResultLocation thumbHeight(Integer thumbHeight) {
        return thumbnailHeight(thumbHeight);
    }


    public InlineQueryResultLocation thumbnailUrl(String thumbnailUrl) {
        this.thumbnail_url = thumbnailUrl;
        return this;
    }

    public InlineQueryResultLocation thumbnailWidth(Integer thumbnailWidth) {
        this.thumbnail_width = thumbnailWidth;
        return this;
    }

    public InlineQueryResultLocation thumbnailHeight(Integer thumbnailHeight) {
        this.thumbnail_height = thumbnailHeight;
        return this;
    }
}
