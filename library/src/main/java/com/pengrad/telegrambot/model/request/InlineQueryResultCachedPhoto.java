package com.pengrad.telegrambot.model.request;

import java.io.Serializable;

/**
 * Stas Parshin
 * 06 May 2016
 */
public class InlineQueryResultCachedPhoto extends InlineQueryResult<InlineQueryResultCachedPhoto> implements Serializable {
    private final static long serialVersionUID = 0L;

    private String photo_file_id;

    private String title;
    private String description;
    private String caption;


    public InlineQueryResultCachedPhoto(String id, String fileId) {
        super("photo", id);
        this.photo_file_id = fileId;
    }

    public InlineQueryResultCachedPhoto title(String title) {
        this.title = title;
        return this;
    }

    public InlineQueryResultCachedPhoto description(String description) {
        this.description = description;
        return this;
    }

    public InlineQueryResultCachedPhoto caption(String caption) {
        this.caption = caption;
        return this;
    }
}
