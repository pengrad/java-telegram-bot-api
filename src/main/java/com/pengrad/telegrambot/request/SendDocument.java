package com.pengrad.telegrambot.request;

/**
 * stas
 * 5/2/16.
 */
public class SendDocument extends AbstractMultipartRequest<SendDocument> {

    public SendDocument(Object chatId, Object document, boolean isMultipart) {
        super(chatId, isMultipart);
        add("document", document);
    }

    public SendDocument caption(String caption) {
        return add("caption", caption);
    }

    @Override
    public String getFileName() {
        return ContentTypes.DOC_FILE_NAME;
    }

    @Override
    public String getContentType() {
        return ContentTypes.DOC_MIME_TYPE;
    }

}
