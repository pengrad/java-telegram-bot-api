package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.impl.TelegramBotClient;
import com.pengrad.telegrambot.model.MessageEntity;
import com.pengrad.telegrambot.model.request.ParseMode;

import java.io.File;

/**
 * stas
 * 5/1/16.
 */
public class SendVoice extends AbstractMultipartRequest<SendVoice> {

    public SendVoice(TelegramBotClient api, Object chatId, String voice) {
        super(api, chatId, voice);
    }

    public SendVoice(TelegramBotClient api, Object chatId, File voice) {
        super(api, chatId, voice);
    }

    public SendVoice(TelegramBotClient api, Object chatId, byte[] voice) {
        super(api, chatId, voice);
    }

    public SendVoice caption(String caption) {
        return add("caption", caption);
    }

    public SendVoice parseMode(ParseMode parseMode) {
        return add("parse_mode", parseMode.name());
    }

    public SendVoice captionEntities(MessageEntity... entities) {
        return add("caption_entities", entities);
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
    public String getDefaultContentType() {
        return ContentTypes.VOICE_MIME_TYPE;
    }
}
