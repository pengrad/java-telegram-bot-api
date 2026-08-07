package com.pengrad.telegrambot.model.request;

import com.pengrad.telegrambot.request.ContentTypes;

import java.io.File;
import java.io.Serializable;

public class InputMediaVoiceNote extends InputMedia<InputMediaVoiceNote> implements Serializable {
    private final static long serialVersionUID = 0L;

    private Integer duration;

    public InputMediaVoiceNote(String media) {
        super("voice_note", media);
    }

    public InputMediaVoiceNote(File media) {
        super("voice_note", media);
    }

    public InputMediaVoiceNote(byte[] media) {
        super("voice_note", media);
    }

    public InputMediaVoiceNote duration(Integer duration) {
        this.duration = duration;
        return this;
    }

    @Override
    public String getDefaultFileName() {
        return ContentTypes.VOICE_FILE_NAME;
    }

    @Override
    public String getDefaultContentType() {
        return ContentTypes.VOICE_MIME_TYPE;
    }
}
