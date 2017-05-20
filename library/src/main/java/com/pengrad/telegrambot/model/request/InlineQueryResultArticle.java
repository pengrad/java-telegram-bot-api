package com.pengrad.telegrambot.model.request;

import java.io.Serializable;

/**
 * stas
 * 1/12/16.
 */
public class InlineQueryResultArticle extends InlineQueryResult<InlineQueryResultArticle> implements Serializable {
    private final static long serialVersionUID = 0L;

    private String title;

    private String url;
    private Boolean hide_url;
    private String description;
    private String thumb_url;
    private Integer thumb_width;
    private Integer thumb_height;

    public InlineQueryResultArticle(String id, String title, String messageText) {
        this(id, title, new InputTextMessageContent(messageText));
    }

    public InlineQueryResultArticle(String id, String title, InputMessageContent inputMessageContent) {
        super("article", id);
        this.title = title;
        inputMessageContent(inputMessageContent);
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
