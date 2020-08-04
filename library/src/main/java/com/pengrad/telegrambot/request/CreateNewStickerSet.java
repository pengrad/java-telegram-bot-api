package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.model.MaskPosition;
import com.pengrad.telegrambot.response.BaseResponse;

/**
 * Stas Parshin
 * 23 July 2017
 */
public class CreateNewStickerSet extends AbstractUploadRequest<CreateNewStickerSet, BaseResponse> {

    public static CreateNewStickerSet tgsSticker(Integer userId, String name, String title, String emojis, Object tgsSticker) {
        return new CreateNewStickerSet(userId, name, title, emojis, "tgs_sticker", tgsSticker);
    }

    public CreateNewStickerSet(Integer userId, String name, String title, Object pngSticker, String emojis) {
        this(userId, name, title, emojis, "png_sticker", pngSticker);
    }

    private CreateNewStickerSet(Integer userId, String name, String title, String emojis, String stickerParam, Object sticker) {
        super(BaseResponse.class, stickerParam, sticker);
        add("user_id", userId);
        add("name", name);
        add("title", title);
        add("emojis", emojis);
    }

    public CreateNewStickerSet containsMasks(boolean containsMasks) {
        return add("contains_masks", containsMasks);
    }

    public CreateNewStickerSet maskPosition(MaskPosition maskPosition) {
        return add("mask_position", maskPosition).containsMasks(true);
    }
}
