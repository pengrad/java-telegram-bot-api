package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.impl.TelegramBotClient;
import com.pengrad.telegrambot.model.MessageEntity;
import com.pengrad.telegrambot.model.request.ParseMode;

import java.io.File;

/**
 * stas
 * 5/2/16.
 */
public class SendDocument extends AbstractMultipartRequest<SendDocument> {

    public SendDocument(TelegramBotClient api, Object chatId, String document) {
        super(api, chatId, document);
    }

    public SendDocument(TelegramBotClient api, Object chatId, File document) {
        super(api, chatId, document);
    }

    public SendDocument(TelegramBotClient api, Object chatId, byte[] document) {
        super(api, chatId, document);
    }

/**
     * @deprecated Use thumbnail instead
     */
    @Deprecated 
    public SendDocument thumb(byte[] thumb) {
        return thumbnail(thumb);
    }

    /**
     * @deprecated Use thumbnail instead
     */
    @Deprecated 
    public SendDocument thumb(File thumb) {
        return thumbnail(thumb);
    }

    public SendDocument thumbnail(byte[] thumbnail) {
        return super.thumbnail(thumbnail);
    }

    public SendDocument thumbnail(File thumbnail) {
        return super.thumbnail(thumbnail);
    }

    public SendDocument caption(String caption) {
        return add("caption", caption);
    }

    public SendDocument parseMode(ParseMode parseMode) {
        return add("parse_mode", parseMode.name());
    }

    public SendDocument captionEntities(MessageEntity... entities) {
        return add("caption_entities", entities);
    }

    public SendDocument disableContentTypeDetection(boolean disableContentTypeDetection) {
        return add("disable_content_type_detection", disableContentTypeDetection);
    }

    @Override
    protected String getFileParamName() {
        return "document";
    }

    @Override
    public String getDefaultFileName() {
        return ContentTypes.DOC_FILE_NAME;
    }

    @Override
    public String getDefaultContentType() {
        return ContentTypes.DOC_MIME_TYPE;
    }

}
