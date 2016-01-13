package com.pengrad.telegrambot.model.request;

/**
 * stas
 * 1/12/16.
 */
public class InlineQueryResultPhoto extends InlineQueryResult {

    private String type;
    private String id;
    private String photo_url;
    private String thumb_url;

    private Integer photo_width;
    private Integer photo_height;
    private String title;
    private String description;
    private String caption;
    private String message_text;
    private ParseMode parse_mode;
    private Boolean disable_web_page_preview;

    public InlineQueryResultPhoto(String id, String photoUrl, String thumbUrl) {
        this.type = "photo";
        this.id = id;
        this.photo_url = photoUrl;
        this.thumb_url = thumbUrl;
    }

    public InlineQueryResultPhoto photoWidth(Integer photoWidth) {
        this.photo_width = photoWidth;
        return this;
    }

    public InlineQueryResultPhoto photoHeight(Integer photoHeight) {
        this.photo_height = photoHeight;
        return this;
    }

    public InlineQueryResultPhoto title(String title) {
        this.title = title;
        return this;
    }

    public InlineQueryResultPhoto description(String description) {
        this.description = description;
        return this;
    }

    public InlineQueryResultPhoto caption(String caption) {
        this.caption = caption;
        return this;
    }

    public InlineQueryResultPhoto messageText(String messageText) {
        this.message_text = messageText;
        return this;
    }

    public InlineQueryResultPhoto parseMode(ParseMode parseMode) {
        this.parse_mode = parseMode;
        return this;
    }

    public InlineQueryResultPhoto disableWebPagePreview(Boolean disableWebPagePreview) {
        this.disable_web_page_preview = disableWebPagePreview;
        return this;
    }
}
