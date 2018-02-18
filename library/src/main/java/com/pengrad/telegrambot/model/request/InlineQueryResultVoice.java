package com.pengrad.telegrambot.model.request;

import java.io.Serializable;

/**
 * Stas Parshin
 * 06 May 2016
 */
public class InlineQueryResultVoice extends InlineQueryResult<InlineQueryResultVoice> implements Serializable {
    private final static long serialVersionUID = 0L;

    private String voice_url;
    private String title;

    private String caption;
    private String parse_mode;
    private Integer voice_duration;

    public InlineQueryResultVoice(String id, String voiceUrl, String title) {
        super("voice", id);
        this.voice_url = voiceUrl;
        this.title = title;
    }

    public InlineQueryResultVoice caption(String caption) {
        this.caption = caption;
        return this;
    }

    public InlineQueryResultVoice voiceDuration(Integer voiceDuration) {
        this.voice_duration = voiceDuration;
        return this;
    }

    public InlineQueryResultVoice parseMode(ParseMode parseMode) {
        this.parse_mode = parseMode.name();
        return this;
    }
}
