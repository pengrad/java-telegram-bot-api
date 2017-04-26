package com.pengrad.telegrambot.model.request;

import java.io.Serializable;

/**
 * Stas Parshin
 * 06 May 2016
 */
public class InlineQueryResultCachedAudio extends InlineQueryResult<InlineQueryResultCachedAudio> implements Serializable {
    private final static long serialVersionUID = 0L;

    private String audio_file_id;

    private String caption;

    public InlineQueryResultCachedAudio(String id, String fileId) {
        super("audio", id);
        this.audio_file_id = fileId;
    }

    public InlineQueryResultCachedAudio caption(String caption) {
        this.caption = caption;
        return this;
    }
}
