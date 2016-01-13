package com.pengrad.telegrambot.model.request;

/**
 * stas
 * 1/12/16.
 */
public class InlineQueryResultGif extends InlineQueryResult {

    private String type;
    private String id;
    private String gif_url;
    private String thumb_url;

    private Integer gif_width;
    private Integer gif_height;
    private String title;
    private String caption;
    private String message_text;
    private ParseMode parse_mode;
    private Boolean disable_web_page_preview;

    public InlineQueryResultGif(String id, String gifUrl, String thumbUrl) {
        this.type = "gif";
        this.id = id;
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

    public InlineQueryResultGif title(String title) {
        this.title = title;
        return this;
    }

    public InlineQueryResultGif caption(String caption) {
        this.caption = caption;
        return this;
    }

    public InlineQueryResultGif messageText(String messageText) {
        this.message_text = messageText;
        return this;
    }

    public InlineQueryResultGif parseMode(ParseMode parseMode) {
        this.parse_mode = parseMode;
        return this;
    }

    public InlineQueryResultGif disableWebPagePreview(Boolean disableWebPagePreview) {
        this.disable_web_page_preview = disableWebPagePreview;
        return this;
    }
}
