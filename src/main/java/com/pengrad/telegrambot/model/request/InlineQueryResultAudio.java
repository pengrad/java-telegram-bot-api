package com.pengrad.telegrambot.model.request;

/**
 * Stas Parshin
 * 06 May 2016
 */
public class InlineQueryResultAudio extends InlineQueryResult<InlineQueryResultAudio> {

    private String audio_url;
    private String title;

    private String performer;
    private Integer audio_duration;

    public InlineQueryResultAudio(String id, String audioUrl, String title) {
        super("audio", id);
        this.audio_url = audioUrl;
        this.title = title;
    }

    public InlineQueryResultAudio performer(String performer) {
        this.performer = performer;
        return this;
    }

    public InlineQueryResultAudio audioDuration(Integer audioDuration) {
        this.audio_duration = audioDuration;
        return this;
    }
}
