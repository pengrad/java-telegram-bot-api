package com.pengrad.telegrambot.request;

/**
 * stas
 * 5/1/16.
 */
public class SendVoice extends AbstractMultipartRequest<SendVoice> {

    public SendVoice(Object chatId, Object voice, boolean isMultipart) {
        super(chatId, isMultipart);
        add("voice", voice);
    }

    public SendVoice duration(int duration) {
        return add("duration", duration);
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
