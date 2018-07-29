package com.pengrad.telegrambot.model.request;

import com.pengrad.telegrambot.request.ContentTypes;

import java.io.File;
import java.io.Serializable;

/**
 * Stas Parshin
 * 28 July 2018
 */
public class InputMediaDocument extends InputMedia<InputMediaDocument> implements Serializable {
    private final static long serialVersionUID = 0L;

    public InputMediaDocument(String media) {
        super("document", media);
    }

    public InputMediaDocument(File media) {
        super("document", media);
    }

    public InputMediaDocument(byte[] media) {
        super("document", media);
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
