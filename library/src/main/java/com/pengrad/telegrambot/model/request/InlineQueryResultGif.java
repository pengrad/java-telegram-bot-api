package com.pengrad.telegrambot.model.request;

import java.io.Serializable;

/**
 * stas
 * 1/12/16.
 */
public class InlineQueryResultGif extends InlineQueryResult<InlineQueryResultGif> implements Serializable {
    private final static long serialVersionUID = 0L;

    private String gif_url;
    private String thumb_url;

    private Integer gif_width;
    private Integer gif_height;
    private Integer gif_duration;
    private String thumb_mime_type;
    private String title;
    private String caption;
    private String parse_mode;

    public InlineQueryResultGif(String id, String gifUrl, String thumbUrl) {
        super("gif", id);
        this.gif_url = gifUrl;
        this.thumb_url = thumbUrl;
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

    public InlineQueryResultGif thumbMimeType(String thumbMimeType) {
        this.thumb_mime_type = thumbMimeType;
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
