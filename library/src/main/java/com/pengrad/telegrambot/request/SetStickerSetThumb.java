package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.response.BaseResponse;

/**
 * Stas Parshin
 * 31 March 2020
 */
public class SetStickerSetThumb extends AbstractUploadRequest<AddStickerToSet, BaseResponse> {

    public SetStickerSetThumb(String name, Integer userId, Object thumb) {
        super(BaseResponse.class, "thumb", thumb);
        add("name", name);
        add("user_id", userId);
    }

    public SetStickerSetThumb(String name, Integer userId) {
        super(BaseResponse.class, "name", name);
        add("user_id", userId);
    }
}
