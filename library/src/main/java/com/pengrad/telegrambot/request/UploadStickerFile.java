package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.model.Sticker.Format;
import com.pengrad.telegrambot.response.GetFileResponse;

/**
 * Stas Parshin
 * 23 July 2017
 */
public class UploadStickerFile extends AbstractUploadRequest<UploadStickerFile, GetFileResponse> {

    /**
     * @param stickerFormat must be one of “static”, “animated”, “video”.
     */
    public UploadStickerFile(Long userId, Object sticker, Format stickerFormat) {
        super(GetFileResponse.class, "sticker", sticker);
        add("user_id", userId);
        add("sticker_format", stickerFormat.name().toLowerCase());
    }


}
