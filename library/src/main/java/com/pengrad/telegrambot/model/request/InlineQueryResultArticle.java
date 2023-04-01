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

    private String thumbnail_url;
    private Integer thumbnail_width;
    private Integer thumbnail_height;

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

    /**
     * @deprecated Use thumbnailUrl instead
     */
    @Deprecated
    public InlineQueryResultArticle thumbUrl(String thumbUrl) {
        this.thumbnail_url = thumbUrl;
        return this;
    }

    /**
     * @deprecated Use thumbnailWidth instead
     */
    @Deprecated
    public InlineQueryResultArticle thumbWidth(Integer thumbWidth) {
        this.thumbnail_width = thumbWidth;
        return this;
    }

    /**
     * @deprecated Use thumbnailHeight instead
     */
    @Deprecated    
    public InlineQueryResultArticle thumbHeight(Integer thumbHeight) {
        this.thumbnail_height = thumbHeight;
        return this;
    }


    public InlineQueryResultArticle thumbnailUrl(String thumbnailUrl) {
        this.thumbnail_url = thumbnailUrl;
        return this;
    }

    public InlineQueryResultArticle thumbnailWidth(Integer thumbnailWidth) {
        this.thumbnail_width = thumbnailWidth;
        return this;
    }

    public InlineQueryResultArticle thumbnailHeight(Integer thumbnailHeight) {
        this.thumbnail_height = thumbnailHeight;
        return this;
    }
}
