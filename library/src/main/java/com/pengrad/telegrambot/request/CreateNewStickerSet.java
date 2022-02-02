package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.model.MaskPosition;
import com.pengrad.telegrambot.response.BaseResponse;

/**
 * Stas Parshin
 * 23 July 2017
 */
public class CreateNewStickerSet extends AbstractUploadRequest<CreateNewStickerSet, BaseResponse> {

    public static CreateNewStickerSet tgsSticker(Long userId, String name, String title, String emojis, Object tgsSticker) {
        return new CreateNewStickerSet(userId, name, title, emojis, "tgs_sticker", tgsSticker);
    }

    public static CreateNewStickerSet pngSticker(Long userId, String name, String title, String emojis, Object pngSticker) {
        return new CreateNewStickerSet(userId, name, title, emojis, "png_sticker", pngSticker);
    }

    public static CreateNewStickerSet webmSticker(Long userId, String name, String title, String emojis, Object webmSticker) {
        return new CreateNewStickerSet(userId, name, title, emojis, "webm_sticker", webmSticker);
    }

    /**
     * @deprecated Use static methods according to sticker set type - {@link #pngSticker(Long, String, String, String, Object) for png}, {@link #tgsSticker(Long, String, String, String, Object) for tgs} and {@link #webmSticker(Long, String, String, String, Object) for webm}
     */
    @Deprecated
    public CreateNewStickerSet(Long userId, String name, String title, Object pngSticker, String emojis) {
        this(userId, name, title, emojis, "png_sticker", pngSticker);
    }

    private CreateNewStickerSet(Long userId, String name, String title, String emojis, String stickerParam, Object sticker) {
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
