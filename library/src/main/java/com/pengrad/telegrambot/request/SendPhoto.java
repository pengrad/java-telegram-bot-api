package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.model.MessageEntity;
import com.pengrad.telegrambot.model.request.ParseMode;

import java.io.File;

/**
 * stas
 * 5/1/16.
 */
public class SendPhoto extends AbstractMultipartRequest<SendPhoto> {

    public SendPhoto(Object chatId, String photo) {
        super(chatId, photo);
    }

    public SendPhoto(Object chatId, File photo) {
        super(chatId, photo);
    }

    public SendPhoto(Object chatId, byte[] photo) {
        super(chatId, photo);
    }

    public SendPhoto caption(String caption) {
        return add("caption", caption);
    }

    public SendPhoto parseMode(ParseMode parseMode) {
        return add("parse_mode", parseMode.name());
    }

    public SendPhoto captionEntities(MessageEntity... entities) {
        return add("caption_entities", entities);
    }

    public SendPhoto hasSpoiler(boolean has_spoiler) {
        return add("has_spoiler", has_spoiler);
    }

    public SendPhoto showCaptionAboveMedia(Boolean showCaptionAboveMedia) {
        return add("show_caption_above_media", showCaptionAboveMedia);
    }

    @Override
    protected String getFileParamName() {
        return "photo";
    }

    @Override
    public String getDefaultFileName() {
        return ContentTypes.PHOTO_FILE_NAME;
    }

    @Override
    public String getDefaultContentType() {
        return ContentTypes.PHOTO_MIME_TYPE;
    }
}
