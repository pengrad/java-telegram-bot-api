package com.pengrad.telegrambot.request;

import java.io.File;

/**
 * stas
 * 5/2/16.
 */
public class SendDocument extends AbstractMultipartRequest<SendDocument> {

    private String fileName;

    public SendDocument(Object chatId, String document) {
        super(chatId, document);
    }

    public SendDocument(Object chatId, File document) {
        super(chatId, document);
        fileName = document.getName();
    }

    public SendDocument(Object chatId, byte[] document) {
        super(chatId, document);
    }

    public SendDocument caption(String caption) {
        return add("caption", caption);
    }

    public SendDocument fileName(String fileName) {
        this.fileName = fileName;
        return thisAsT;
    }

    @Override
    protected String getFileParamName() {
        return "document";
    }

    @Override
    public String getFileName() {
        if (fileName != null && !fileName.isEmpty()) {
            return fileName;
        } else {
            return ContentTypes.DOC_FILE_NAME;
        }
    }

    @Override
    public String getContentType() {
        return ContentTypes.DOC_MIME_TYPE;
    }

}
