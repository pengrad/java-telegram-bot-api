package com.pengrad.telegrambot.request;

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

    public SendDocument caption(String caption) {
        return add("caption", caption);
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
