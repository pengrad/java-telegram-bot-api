package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.model.MessageEntity;
import com.pengrad.telegrambot.model.request.ParseMode;

import java.io.File;

/**
 * stas
 * 5/2/16.
 */
public class SendDocument extends AbstractMultipartRequest<SendDocument> {

    public SendDocument(Object chatId, String document) {
        super(chatId, document);
    }

    public SendDocument(Object chatId, File document) {
        super(chatId, document);
    }

    public SendDocument(Object chatId, byte[] document) {
        super(chatId, document);
    }

    public SendDocument thumb(byte[] thumb) {
        return super.thumb(thumb);
    }

    public SendDocument thumb(File thumb) {
        return super.thumb(thumb);
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
    public String getContentType() {
        return ContentTypes.DOC_MIME_TYPE;
    }

}
