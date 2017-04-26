package com.pengrad.telegrambot.model.request;

import java.io.Serializable;

/**
 * Stas Parshin
 * 06 May 2016
 */
public class InlineQueryResultCachedVoice extends InlineQueryResult<InlineQueryResultCachedVoice> implements Serializable {
    private final static long serialVersionUID = 0L;

    private String voice_file_id;
    private String title;

    private String caption;

    public InlineQueryResultCachedVoice(String id, String fileId, String title) {
        super("voice", id);
        this.voice_file_id = fileId;
        this.title = title;
    }

    public InlineQueryResultCachedVoice caption(String caption) {
        this.caption = caption;
        return this;
    }
}
