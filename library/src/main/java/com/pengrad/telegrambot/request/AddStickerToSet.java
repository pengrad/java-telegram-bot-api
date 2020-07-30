package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.model.MaskPosition;
import com.pengrad.telegrambot.response.BaseResponse;

/**
 * Stas Parshin
 * 23 July 2017
 */
public class AddStickerToSet extends AbstractUploadRequest<AddStickerToSet, BaseResponse> {

    public static AddStickerToSet tgsSticker(Integer userId, String name, String emojis, Object tgsSticker) {
        return new AddStickerToSet(userId, name, emojis, "tgs_sticker", tgsSticker);
    }

    public AddStickerToSet(Integer userId, String name, Object pngSticker, String emojis) {
        this(userId, name, emojis, "png_sticker", pngSticker);
    }

    private AddStickerToSet(Integer userId, String name, String emojis, String stickerParam, Object sticker) {
        super(BaseResponse.class, stickerParam, sticker);
        add("user_id", userId);
        add("name", name);
        add("emojis", emojis);
    }

    public AddStickerToSet maskPosition(MaskPosition maskPosition) {
        return add("mask_position", maskPosition);
    }
}
