package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.model.MaskPosition;
import com.pengrad.telegrambot.model.Sticker.Type;
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

    /**
     * @deprecated Use stickerType(Type.mask) instead
     */
    @Deprecated
    public CreateNewStickerSet containsMasks(boolean containsMasks) {
        return add("contains_masks", containsMasks);
    }

    public CreateNewStickerSet maskPosition(MaskPosition maskPosition) {
        return add("mask_position", maskPosition);
    }

    /**
     * Type of stickers in the set.
     * @param stickerType pass “regular” or “mask”. "custom_emoji" is defaulted to "regular".
     * @return a CreateNewStickerSet object
     */
    public CreateNewStickerSet stickerType(Type stickerType) {
        return add("sticker_type", stickerType.name());
    }

    /**
     * 
     * @param stickerType Pass True if stickers in the sticker set must be repainted to the color of text when used in messages, the accent color if used as emoji status, white on chat photos, or another appropriate color based on context; for custom emoji sticker sets only.
     * @return a CreateNewStickerSet object
     */
    public CreateNewStickerSet needsRepainting(boolean needsRepainting) {
        return add("needs_repainting", needsRepainting);
    }
}
