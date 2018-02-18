package com.pengrad.telegrambot.model.request;

import java.io.Serializable;

/**
 * Stas Parshin
 * 06 May 2016
 */
public class InlineQueryResultDocument extends InlineQueryResult<InlineQueryResultDocument> implements Serializable {
    private final static long serialVersionUID = 0L;

    public static final String MIME_APP_PDFL = "application/pdf";
    public static final String MIME_APP_ZIP = "application/zip";

    private String title;
    private String document_url;
    private String mime_type;

    private String caption;
    private String parse_mode;
    private String description;
    private String thumb_url;
    private Integer thumb_width;
    private Integer thumb_height;


    public InlineQueryResultDocument(String id, String documentUrl, String title, String mimeType) {
        super("document", id);
        this.document_url = documentUrl;
        this.title = title;
        this.mime_type = mimeType;
    }

    public InlineQueryResultDocument caption(String caption) {
        this.caption = caption;
        return this;
    }

    public InlineQueryResultDocument parseMode(ParseMode parseMode) {
        this.parse_mode = parseMode.name();
        return this;
    }

    public InlineQueryResultDocument description(String description) {
        this.description = description;
        return this;
    }

    public InlineQueryResultDocument thumbUrl(String thumbUrl) {
        this.thumb_url = thumbUrl;
        return this;
    }

    public InlineQueryResultDocument thumbWidth(Integer thumbWidth) {
        this.thumb_width = thumbWidth;
        return this;
    }

    public InlineQueryResultDocument thumbHeight(Integer thumbHeight) {
        this.thumb_height = thumbHeight;
        return this;
    }
}
