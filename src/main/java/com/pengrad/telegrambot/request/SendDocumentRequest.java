package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.impl.TelegramApi;

/**
 * stas
 * 5/2/16.
 */
public class SendDocumentRequest extends AbstractMultipartRequest<SendDocumentRequest> {

    public SendDocumentRequest(TelegramApi api, Object chatId, Object document, boolean isMultipart) {
        super(api, chatId, isMultipart);
        add("document", document);
    }

    public SendDocumentRequest caption(String caption) {
        return add("caption", caption);
    }

    @Override
    public String getMethod() {
        return "sendDocument";
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
