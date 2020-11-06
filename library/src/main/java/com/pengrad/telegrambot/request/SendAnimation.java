package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.model.MessageEntity;
import com.pengrad.telegrambot.model.request.ParseMode;

import java.io.File;

/**
 * Stas Parshin
 * 28 July 2018
 */
public class SendAnimation extends AbstractMultipartRequest<SendAnimation> {

    public SendAnimation(Object chatId, String animation) {
        super(chatId, animation);
    }

    public SendAnimation(Object chatId, File animation) {
        super(chatId, animation);
    }

    public SendAnimation(Object chatId, byte[] animation) {
        super(chatId, animation);
    }

    public SendAnimation duration(int duration) {
        return add("duration", duration);
    }

    public SendAnimation width(int width) {
        return add("width", width);
    }

    public SendAnimation height(int height) {
        return add("height", height);
    }

    public SendAnimation thumb(byte[] thumb) {
        return super.thumb(thumb);
    }

    public SendAnimation thumb(File thumb) {
        return super.thumb(thumb);
    }

    public SendAnimation caption(String caption) {
        return add("caption", caption);
    }

    public SendAnimation parseMode(ParseMode parseMode) {
        return add("parse_mode", parseMode.name());
    }

    public SendAnimation captionEntities(MessageEntity... entities) {
        return add("caption_entities", entities);
    }

    @Override
    protected String getFileParamName() {
        return "animation";
    }

    @Override
    public String getDefaultFileName() {
        return ContentTypes.GIF_FILE_NAME;
    }

    @Override
    public String getContentType() {
        return ContentTypes.GIF_MIME_TYPE;
    }
}
