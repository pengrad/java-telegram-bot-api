package com.pengrad.telegrambot.model.request;

import java.io.Serializable;

/**
 * stas
 * 1/12/16.
 */
public class InlineQueryResultMpeg4Gif extends InlineQueryResult<InlineQueryResultMpeg4Gif> implements Serializable {
    private final static long serialVersionUID = 0L;

    private String mpeg4_url;

    private String thumbnail_url;
    private String thumbnail_mime_type;

    private Integer mpeg4_width;
    private Integer mpeg4_height;
    private Integer mpeg4_duration;

    private String title;
    private String caption;
    private String parse_mode;

    public InlineQueryResultMpeg4Gif(String id, String mpeg4Url, String thumbnailUrl) {
        super("mpeg4_gif", id);
        this.mpeg4_url = mpeg4Url;
        this.thumbnail_url = thumbnailUrl;
    }

    public InlineQueryResultMpeg4Gif mpeg4Width(Integer mpeg4Width) {
        this.mpeg4_width = mpeg4Width;
        return this;
    }

    public InlineQueryResultMpeg4Gif mpeg4Height(Integer mpeg4Height) {
        this.mpeg4_height = mpeg4Height;
        return this;
    }

    public InlineQueryResultMpeg4Gif mpeg4Duration(Integer mpeg4Duration) {
        this.mpeg4_duration = mpeg4Duration;
        return this;
    }

    /**
     * @deprecated Use thumbnailMimeType instead
     */
    @Deprecated 
    public InlineQueryResultMpeg4Gif thumbMimeType(String thumbMimeType) {
        return thumbnailMimeType(thumbMimeType);
    }

    public InlineQueryResultMpeg4Gif thumbnailMimeType(String thumbnailMimeType) {
        this.thumbnail_mime_type = thumbnailMimeType;
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

    public InlineQueryResultMpeg4Gif parseMode(ParseMode parseMode) {
        this.parse_mode = parseMode.name();
        return this;
    }
}
