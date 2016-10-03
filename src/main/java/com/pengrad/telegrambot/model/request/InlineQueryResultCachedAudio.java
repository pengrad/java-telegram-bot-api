package com.pengrad.telegrambot.model.request;

/**
 * Stas Parshin
 * 06 May 2016
 */
public class InlineQueryResultCachedAudio extends InlineQueryResult<InlineQueryResultCachedAudio> {

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
