package com.pengrad.telegrambot.model.request;

/**
 * stas
 * 1/12/16.
 */
public class InlineQueryResultPhoto extends InlineQueryResult<InlineQueryResultPhoto> {

    private String photo_url;
    private String thumb_url;

    private Integer photo_width;
    private Integer photo_height;
    private String title;
    private String description;
    private String caption;

    public InlineQueryResultPhoto(String id, String photoUrl, String thumbUrl) {
        super("photo", id);
        this.photo_url = photoUrl;
        this.thumb_url = thumbUrl;
    }

    public InlineQueryResultPhoto photoWidth(Integer photoWidth) {
        this.photo_width = photoWidth;
        return this;
    }

    public InlineQueryResultPhoto photoHeight(Integer photoHeight) {
        this.photo_height = photoHeight;
        return this;
    }

    public InlineQueryResultPhoto title(String title) {
        this.title = title;
        return this;
    }

    public InlineQueryResultPhoto description(String description) {
        this.description = description;
        return this;
    }

    public InlineQueryResultPhoto caption(String caption) {
        this.caption = caption;
        return this;
    }
}
