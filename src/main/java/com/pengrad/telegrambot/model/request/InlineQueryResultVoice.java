package com.pengrad.telegrambot.model.request;

/**
 * Stas Parshin
 * 06 May 2016
 */
public class InlineQueryResultVoice extends InlineQueryResult<InlineQueryResultVoice> {

    private String voice_url;
    private String title;

    private Integer voice_duration;

    public InlineQueryResultVoice(String id, String voiceUrl, String title) {
        super("voice", id);
        this.voice_url = voiceUrl;
        this.title = title;
    }

    public InlineQueryResultVoice voiceDuration(Integer voiceDuration) {
        this.voice_duration = voiceDuration;
        return this;
    }
}
