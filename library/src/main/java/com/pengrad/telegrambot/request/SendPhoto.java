package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.impl.TelegramBotClient;
import com.pengrad.telegrambot.model.MessageEntity;
import com.pengrad.telegrambot.model.request.ParseMode;

import java.io.File;

/**
 * stas
 * 5/1/16.
 */
public class SendPhoto extends AbstractMultipartRequest<SendPhoto> {

    public SendPhoto(TelegramBotClient api, Object chatId, String photo) {
        super(api, chatId, photo);
    }

    public SendPhoto(TelegramBotClient api, Object chatId, File photo) {
        super(api, chatId, photo);
    }

    public SendPhoto(TelegramBotClient api, Object chatId, byte[] photo) {
        super(api, chatId, photo);
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
