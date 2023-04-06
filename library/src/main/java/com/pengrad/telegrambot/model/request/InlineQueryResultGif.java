package com.pengrad.telegrambot.model.request;

import java.io.Serializable;

/**
 * stas
 * 1/12/16.
 */
public class InlineQueryResultGif extends InlineQueryResult<InlineQueryResultGif> implements Serializable {
    private final static long serialVersionUID = 0L;

    private String gif_url;

    private String thumbnail_url;
    private String thumbnail_mime_type;

    private Integer gif_width;
    private Integer gif_height;
    private Integer gif_duration;

    private String title;
    private String caption;
    private String parse_mode;

    public InlineQueryResultGif(String id, String gifUrl, String thumbnailUrl) {
        super("gif", id);
        this.gif_url = gifUrl;
        this.thumbnail_url = thumbnailUrl;
    }

    public InlineQueryResultGif gifWidth(Integer gifWidth) {
        this.gif_width = gifWidth;
        return this;
    }

    public InlineQueryResultGif gifHeight(Integer gifHeight) {
        this.gif_height = gifHeight;
        return this;
    }

    public InlineQueryResultGif gifDuration(Integer gifDuration) {
        this.gif_duration = gifDuration;
        return this;
    }

    /**
     * @deprecated Use thumbnailMimeType instead
     */
    @Deprecated 
    public InlineQueryResultGif thumbMimeType(String thumbMimeType) {
        return thumbnailMimeType(thumbMimeType);
    }

    public InlineQueryResultGif thumbnailMimeType(String thumbnailMimeType) {
        this.thumbnail_mime_type = thumbnailMimeType;
        return this;
    }

    public InlineQueryResultGif title(String title) {
        this.title = title;
        return this;
    }

    public InlineQueryResultGif caption(String caption) {
        this.caption = caption;
        return this;
    }

    public InlineQueryResultGif parseMode(ParseMode parseMode) {
        this.parse_mode = parseMode.name();
        return this;
    }
}
