package com.pengrad.telegrambot.model.request;

/**
 * Stas Parshin
 * 06 May 2016
 */
public class InlineQueryResultCachedVideo extends InlineQueryResult<InlineQueryResultCachedVideo> {

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
