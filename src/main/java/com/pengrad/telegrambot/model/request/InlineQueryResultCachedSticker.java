package com.pengrad.telegrambot.model.request;

/**
 * Stas Parshin
 * 06 May 2016
 */
public class InlineQueryResultCachedSticker extends InlineQueryResult<InlineQueryResultCachedSticker> {

    private String sticker_file_id;

    public InlineQueryResultCachedSticker(String id, String fileId) {
        super("sticker", id);
        this.sticker_file_id = fileId;
    }
}
