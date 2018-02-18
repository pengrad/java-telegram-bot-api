package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.model.request.ParseMode;

import java.io.File;

/**
 * stas
 * 5/1/16.
 */
public class SendVoice extends AbstractMultipartRequest<SendVoice> {

    public SendVoice(Object chatId, String voice) {
        super(chatId, voice);
    }

    public SendVoice(Object chatId, File voice) {
        super(chatId, voice);
    }

    public SendVoice(Object chatId, byte[] voice) {
        super(chatId, voice);
    }

    public SendVoice caption(String caption) {
        return add("caption", caption);
    }

    public SendVoice parseMode(ParseMode parseMode) {
        return add("parse_mode", parseMode.name());
    }

    public SendVoice duration(int duration) {
        return add("duration", duration);
    }

    @Override
    protected String getFileParamName() {
        return "voice";
    }

    @Override
    public String getDefaultFileName() {
        return ContentTypes.VOICE_FILE_NAME;
    }

    @Override
    public String getContentType() {
        return ContentTypes.VOICE_MIME_TYPE;
    }
}
