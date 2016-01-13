package com.pengrad.telegrambot.model.request;

/**
 * stas
 * 1/12/16.
 */
public class InlineQueryResultMpeg4Gif extends InlineQueryResult {

    private String type;
    private String id;
    private String mpeg4_url;
    private String thumb_url;

    private Integer mpeg4_width;
    private Integer mpeg4_height;
    private String title;
    private String caption;
    private String message_text;
    private ParseMode parse_mode;
    private Boolean disable_web_page_preview;

    public InlineQueryResultMpeg4Gif(String id, String mpeg4Url, String thumbUrl) {
        this.type = "mpeg4_gif";
        this.id = id;
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

    public InlineQueryResultMpeg4Gif messageText(String messageText) {
        this.message_text = messageText;
        return this;
    }

    public InlineQueryResultMpeg4Gif parseMode(ParseMode parseMode) {
        this.parse_mode = parseMode;
        return this;
    }

    public InlineQueryResultMpeg4Gif disableWebPagePreview(Boolean disableWebPagePreview) {
        this.disable_web_page_preview = disableWebPagePreview;
        return this;
    }
}
