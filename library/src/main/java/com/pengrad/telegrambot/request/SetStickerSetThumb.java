package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.response.BaseResponse;

/**
 * Stas Parshin
 * 31 March 2020
 */
public class SetStickerSetThumb extends AbstractUploadRequest<AddStickerToSet, BaseResponse> {

    /**
     * @deprecated Use SetStickerSetThumbnail instead (since API v6.6)
     */
    @Deprecated
    public SetStickerSetThumb(String name, Long userId, Object thumb) {
        super(BaseResponse.class, "thumb", thumb);
        add("name", name);
        add("user_id", userId);
    }

    public SetStickerSetThumb(String name, Long userId) {
        super(BaseResponse.class, "name", name);
        add("user_id", userId);
    }
}
