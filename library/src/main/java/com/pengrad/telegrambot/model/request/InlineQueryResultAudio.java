package com.pengrad.telegrambot.model.request;

import java.io.Serializable;

/**
 * Stas Parshin
 * 06 May 2016
 */
public class InlineQueryResultAudio extends InlineQueryResult<InlineQueryResultAudio> implements Serializable {
    private final static long serialVersionUID = 0L;

    private String audio_url;
    private String title;

    private String caption;
    private String parse_mode;
    private String performer;
    private Integer audio_duration;

    public InlineQueryResultAudio(String id, String audioUrl, String title) {
        super("audio", id);
        this.audio_url = audioUrl;
        this.title = title;
    }

    public InlineQueryResultAudio caption(String caption) {
        this.caption = caption;
        return this;
    }

    public InlineQueryResultAudio parseMode(ParseMode parseMode) {
        this.parse_mode = parseMode.name();
        return this;
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
