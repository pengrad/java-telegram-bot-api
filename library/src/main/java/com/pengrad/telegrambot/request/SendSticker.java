package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.impl.TelegramBotClient;

import java.io.File;

/**
 * stas
 * 5/2/16.
 */
public class SendSticker extends AbstractMultipartRequest<SendSticker> {

    public SendSticker(TelegramBotClient api, Object chatId, String sticker) {
        super(api, chatId, sticker);
    }

    public SendSticker(TelegramBotClient api, Object chatId, File sticker) {
        super(api, chatId, sticker);
    }

    public SendSticker(TelegramBotClient api, Object chatId, byte[] sticker) {
        super(api, chatId, sticker);
    }


    /**
     * 
     * @param emoji Emoji associated with the sticker; only for just uploaded stickers
     * @return
     */
    public SendSticker emoji(String emoji) {
        add("emoji", emoji);
        return this;
    }

    public SendSticker thumbnail(byte[] thumbnail) {
        return super.thumbnail(thumbnail);
    }

    public SendSticker thumbnail(File thumbnail) {
        return super.thumbnail(thumbnail);
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
    public String getDefaultContentType() {
        return ContentTypes.PHOTO_MIME_TYPE;
    }

}
