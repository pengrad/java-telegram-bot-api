package com.pengrad.telegrambot.model.request;

import java.io.Serializable;

/**
 * Stas Parshin
 * 06 May 2016
 */
public class InlineQueryResultCachedVideo extends InlineQueryResult<InlineQueryResultCachedVideo> implements Serializable {
    private final static long serialVersionUID = 0L;

    private String video_file_id;
    private String title;

    private String description;
    private String caption;


    public InlineQueryResultCachedVideo(String id, String fileId, String title) {
        super("video", id);
        this.video_file_id = fileId;
        this.title = title;
    }

    public InlineQueryResultCachedVideo description(String description) {
        this.description = description;
        return this;
    }

    public InlineQueryResultCachedVideo caption(String caption) {
        this.caption = caption;
        return this;
    }
}
