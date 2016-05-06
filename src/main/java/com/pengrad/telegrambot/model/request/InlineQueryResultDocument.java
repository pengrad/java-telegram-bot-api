package com.pengrad.telegrambot.model.request;

/**
 * Stas Parshin
 * 06 May 2016
 */
public class InlineQueryResultDocument extends InlineQueryResult<InlineQueryResultDocument> {

    public static final String MIME_APP_PDFL = "application/pdf";
    public static final String MIME_APP_ZIP = "application/zip";

    private String title;
    private String document_url;
    private String mime_type;

    private String caption;
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
