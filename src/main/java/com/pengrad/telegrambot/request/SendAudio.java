package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.impl.TelegramApi;

/**
 * stas
 * 5/2/16.
 */
public class SendAudio extends AbstractMultipartRequest<SendAudio> {

    public SendAudio(TelegramApi api, Object chatId, Object audio, boolean isMultipart) {
        super(api, chatId, isMultipart);
        add("audio", audio);
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
    public String getFileName() {
        return ContentTypes.AUDIO_FILE_NAME;
    }

    @Override
    public String getContentType() {
        return ContentTypes.AUDIO_MIME_TYPE;
    }
}
