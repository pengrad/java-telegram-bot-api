package com.pengrad.telegrambot.request;

import java.io.File;

/**
 * stas
 * 5/2/16.
 */
public class SendAudio extends AbstractMultipartRequest<SendAudio> {

    public SendAudio(Object chatId, String audio) {
        super(chatId, audio);
    }

    public SendAudio(Object chatId, File audio) {
        super(chatId, audio);
    }

    public SendAudio(Object chatId, byte[] audio) {
        super(chatId, audio);
    }

    public SendAudio duration(int duration) {
        return add("duration", duration);
    }

    public SendAudio performer(String performer) {
        return add("performer", performer);
    }

    public SendAudio title(String title) {
        return add("title", title);
    }

    @Override
    protected String getFileParamName() {
        return "audio";
    }

    @Override
    public String getDefaultFileName() {
        return ContentTypes.AUDIO_FILE_NAME;
    }

    @Override
    public String getContentType() {
        return ContentTypes.AUDIO_MIME_TYPE;
    }
}
