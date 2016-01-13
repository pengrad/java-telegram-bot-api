package com.pengrad.telegrambot.model.request;

/**
 * stas
 * 1/12/16.
 */
public class InlineQueryResultArticle extends InlineQueryResult {

    private String type;
    private String id;
    private String title;
    private String message_text;

    private ParseMode parse_mode;
    private Boolean disable_web_page_preview;
    private String url;
    private Boolean hide_url;
    private String description;
    private String thumb_url;
    private Integer thumb_width;
    private Integer thumb_height;

    public InlineQueryResultArticle(String id, String title, String messageText) {
        this.type = "article";
        this.id = id;
        this.title = title;
        this.message_text = messageText;
    }

    public InlineQueryResultArticle parseMode(ParseMode parseMode) {
        this.parse_mode = parseMode;
        return this;
    }

    public InlineQueryResultArticle disableWebPagePreview(Boolean disableWebPagePreview) {
        this.disable_web_page_preview = disableWebPagePreview;
        return this;
    }

    public InlineQueryResultArticle url(String url) {
        this.url = url;
        return this;
    }

    public InlineQueryResultArticle hideUrl(Boolean hideUrl) {
        this.hide_url = hideUrl;
        return this;
    }

    public InlineQueryResultArticle description(String description) {
        this.description = description;
        return this;
    }

    public InlineQueryResultArticle thumbUrl(String thumbUrl) {
        this.thumb_url = thumbUrl;
        return this;
    }

    public InlineQueryResultArticle thumbWidth(Integer thumbWidth) {
        this.thumb_width = thumbWidth;
        return this;
    }

    public InlineQueryResultArticle thumbHeight(Integer thumbHeight) {
        this.thumb_height = thumbHeight;
        return this;
    }
}
