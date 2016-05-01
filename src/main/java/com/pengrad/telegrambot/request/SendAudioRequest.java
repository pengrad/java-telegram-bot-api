package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.impl.TelegramApi;

/**
 * stas
 * 5/2/16.
 */
public class SendAudioRequest extends AbstractMultipartRequest<SendAudioRequest> {

    public SendAudioRequest(TelegramApi api, Object chatId, Object audio, boolean isMultipart) {
        super(api, chatId, isMultipart);
        add("audio", audio);
    }

    public SendAudioRequest duration(int duration) {
        return add("duration", duration);
    }

    public SendAudioRequest performer(String performer) {
        return add("performer", performer);
    }

    public SendAudioRequest title(String title) {
        return add("title", title);
    }

    @Override
    public String getMethod() {
        return "sendAudio";
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
