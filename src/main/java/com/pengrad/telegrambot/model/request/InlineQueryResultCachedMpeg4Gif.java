package com.pengrad.telegrambot.model.request;

/**
 * Stas Parshin
 * 06 May 2016
 */
public class InlineQueryResultCachedMpeg4Gif extends InlineQueryResult<InlineQueryResultCachedMpeg4Gif> {

    private String mpeg4_file_id;

    private String title;
    private String caption;


    public InlineQueryResultCachedMpeg4Gif(String id, String fileId) {
        super("mpeg4_gif", id);
        this.mpeg4_file_id = fileId;
    }

    public InlineQueryResultCachedMpeg4Gif title(String title) {
        this.title = title;
        return this;
    }

    public InlineQueryResultCachedMpeg4Gif caption(String caption) {
        this.caption = caption;
        return this;
    }
}
