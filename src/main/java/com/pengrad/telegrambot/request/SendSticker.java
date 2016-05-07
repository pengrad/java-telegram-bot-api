package com.pengrad.telegrambot.request;

/**
 * stas
 * 5/2/16.
 */
public class SendSticker extends AbstractMultipartRequest<SendSticker> {

    public SendSticker(Object chatId, Object sticker, boolean isMultipart) {
        super(chatId, isMultipart);
        add("sticker", sticker);
    }

    @Override
    public String getFileName() {
        return ContentTypes.PHOTO_FILE_NAME;
    }

    @Override
    public String getContentType() {
        return ContentTypes.PHOTO_MIME_TYPE;
    }

}
