package com.pengrad.telegrambot.model.request;

import java.io.Serializable;

/**
 * Stas Parshin
 * 06 May 2016
 */
public class InlineQueryResultCachedGif extends InlineQueryResult<InlineQueryResultCachedGif> implements Serializable {
    private final static long serialVersionUID = 0L;

    private String gif_file_id;

    private String title;
    private String caption;
    private String parse_mode;

    public InlineQueryResultCachedGif(String id, String fileId) {
        super("gif", id);
        this.gif_file_id = fileId;
    }

    public InlineQueryResultCachedGif title(String title) {
        this.title = title;
        return this;
    }

    public InlineQueryResultCachedGif caption(String caption) {
        this.caption = caption;
        return this;
    }

    public InlineQueryResultCachedGif parseMode(ParseMode parseMode) {
        this.parse_mode = parseMode.name();
        return this;
    }
}
