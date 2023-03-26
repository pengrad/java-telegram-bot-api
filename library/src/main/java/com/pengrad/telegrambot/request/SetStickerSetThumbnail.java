package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.response.BaseResponse;

/**
 * Stas Parshin
 * 31 March 2020
 */
public class SetStickerSetThumbnail extends AbstractUploadRequest<AddStickerToSet, BaseResponse> {

    public SetStickerSetThumbnail(String name, Long userId, Object thumbnail) {
        super(BaseResponse.class, "thumbnail", thumbnail);
        add("name", name);
        add("user_id", userId);
    }

    public SetStickerSetThumbnail(String name, Long userId) {
        super(BaseResponse.class, "name", name);
        add("user_id", userId);
    }
}
