package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.model.MessageEntity;
import com.pengrad.telegrambot.model.request.ParseMode;

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

    public SendAudio caption(String caption) {
        return add("caption", caption);
    }

    public SendAudio parseMode(ParseMode parseMode) {
        return add("parse_mode", parseMode.name());
    }

    public SendAudio captionEntities(MessageEntity... entities) {
        return add("caption_entities", entities);
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

    public SendAudio thumb(byte[] thumb) {
        return super.thumb(thumb);
    }

    public SendAudio thumb(File thumb) {
        return super.thumb(thumb);
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
