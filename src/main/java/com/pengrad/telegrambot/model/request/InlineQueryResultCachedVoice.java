package com.pengrad.telegrambot.model.request;

/**
 * Stas Parshin
 * 06 May 2016
 */
public class InlineQueryResultCachedVoice extends InlineQueryResult<InlineQueryResultCachedVoice> {

    private String voice_file_id;
    private String title;

    public InlineQueryResultCachedVoice(String id, String fileId, String title) {
        super("voice", id);
        this.voice_file_id = fileId;
        this.title = title;
    }
}
