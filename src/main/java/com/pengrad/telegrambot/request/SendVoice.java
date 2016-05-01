package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.impl.TelegramApi;

/**
 * stas
 * 5/1/16.
 */
public class SendVoice extends AbstractMultipartRequest<SendVoice> {

    public SendVoice(TelegramApi api, Object chatId, Object voice, boolean isMultipart) {
        super(api, chatId, isMultipart);
        add("voice", voice);
    }

    public SendVoice duration(int duration) {
        return add("duration", duration);
    }

    @Override
    public String getMethod() {
        return "sendVoice";
    }

    @Override
    public String getFileName() {
        return ContentTypes.VOICE_FILE_NAME;
    }

    @Override
    public String getContentType() {
        return ContentTypes.VOICE_MIME_TYPE;
    }
}
