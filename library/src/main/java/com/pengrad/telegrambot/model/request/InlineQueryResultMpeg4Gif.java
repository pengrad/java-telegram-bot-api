package com.pengrad.telegrambot.model.request;

/**
 * stas
 * 1/12/16.
 */
public class InlineQueryResultMpeg4Gif extends InlineQueryResult<InlineQueryResultMpeg4Gif> {

    private String mpeg4_url;
    private String thumb_url;

    private Integer mpeg4_width;
    private Integer mpeg4_height;
    private String title;
    private String caption;

    public InlineQueryResultMpeg4Gif(String id, String mpeg4Url, String thumbUrl) {
        super("mpeg4_gif", id);
        this.mpeg4_url = mpeg4Url;
        this.thumb_url = thumbUrl;
    }

    public InlineQueryResultMpeg4Gif mpeg4Width(Integer mpeg4Width) {
        this.mpeg4_width = mpeg4Width;
        return this;
    }

    public InlineQueryResultMpeg4Gif mpeg4Height(Integer mpeg4Height) {
        this.mpeg4_height = mpeg4Height;
        return this;
    }

    public InlineQueryResultMpeg4Gif title(String title) {
        this.title = title;
        return this;
    }

    public InlineQueryResultMpeg4Gif caption(String caption) {
        this.caption = caption;
        return this;
    }
}
