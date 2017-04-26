package com.pengrad.telegrambot.model.request;

import java.io.Serializable;

/**
 * Stas Parshin
 * 06 May 2016
 */
public class InlineQueryResultCachedDocument extends InlineQueryResult<InlineQueryResultCachedDocument> implements Serializable {
    private final static long serialVersionUID = 0L;

    private String document_file_id;
    private String title;

    private String description;
    private String caption;


    public InlineQueryResultCachedDocument(String id, String fileId, String title) {
        super("document", id);
        this.document_file_id = fileId;
        this.title = title;
    }

    public InlineQueryResultCachedDocument description(String description) {
        this.description = description;
        return this;
    }

    public InlineQueryResultCachedDocument caption(String caption) {
        this.caption = caption;
        return this;
    }
}
