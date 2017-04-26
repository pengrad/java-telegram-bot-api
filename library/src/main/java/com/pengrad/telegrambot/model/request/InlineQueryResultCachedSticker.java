package com.pengrad.telegrambot.model.request;

import java.io.Serializable;

/**
 * Stas Parshin
 * 06 May 2016
 */
public class InlineQueryResultCachedSticker extends InlineQueryResult<InlineQueryResultCachedSticker> implements Serializable {
    private final static long serialVersionUID = 0L;

    private String sticker_file_id;

    public InlineQueryResultCachedSticker(String id, String fileId) {
        super("sticker", id);
        this.sticker_file_id = fileId;
    }
}
