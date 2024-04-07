package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.model.MaskPosition;
import com.pengrad.telegrambot.model.request.InputSticker;
import com.pengrad.telegrambot.response.BaseResponse;

/**
 * Stas Parshin
 * 23 July 2017
 */
public class AddStickerToSet extends AbstractUploadRequest<AddStickerToSet, BaseResponse> {

    public AddStickerToSet(Long userId, String name, InputSticker sticker) {
        super(BaseResponse.class, attachName(sticker), attachment(sticker));
        add("user_id", userId);
        add("name", name);
        add("sticker", sticker);
    }

    private static String attachName(InputSticker sticker) {
        return sticker.getAttachment() != null ? sticker.getAttachName() : "sticker_id";
    }

    private static Object attachment(InputSticker sticker) {
        return sticker.getAttachment() != null ? sticker.getAttachment() : "sticker_id";
    }

    /**
     * @deprecated Use maskPosition on InputSticker (since API v6.6)
     */
    @Deprecated
    public AddStickerToSet maskPosition(MaskPosition maskPosition) {
        return add("mask_position", maskPosition);
    }
}
