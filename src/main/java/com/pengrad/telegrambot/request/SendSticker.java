package com.pengrad.telegrambot.request;

import java.io.File;

/**
 * stas
 * 5/2/16.
 */
public class SendSticker extends AbstractMultipartRequest<SendSticker> {

    public SendSticker(Object chatId, String sticker) {
        super(chatId, sticker);
    }

    public SendSticker(Object chatId, File sticker) {
        super(chatId, sticker);
    }

    public SendSticker(Object chatId, byte[] sticker) {
        super(chatId, sticker);
    }

    @Override
    protected String getFileParamName() {
        return "sticker";
    }

    @Override
    public String getDefaultFileName() {
        return ContentTypes.PHOTO_FILE_NAME;
    }

    @Override
    public String getContentType() {
        return ContentTypes.PHOTO_MIME_TYPE;
    }

}
