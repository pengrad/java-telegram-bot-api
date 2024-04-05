package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.model.Sticker;
import com.pengrad.telegrambot.response.BaseResponse;

/**
 * Stas Parshin
 * 31 March 2020
 */
public class SetStickerSetThumbnail extends AbstractUploadRequest<AddStickerToSet, BaseResponse> {

    /**
     * @deprecated Format parameter is required since Bot API 7.2
     */
    @Deprecated
    public SetStickerSetThumbnail(String name, Long userId, Object thumbnail) {
        super(BaseResponse.class, "thumbnail", thumbnail);
        add("name", name);
        add("user_id", userId);
    }

    /**
     * @deprecated Format parameter is required since Bot API 7.2
     */
    @Deprecated
    public SetStickerSetThumbnail(String name, Long userId) {
        super(BaseResponse.class, "name", name);
        add("user_id", userId);
    }

    public SetStickerSetThumbnail(String name, Long userId, Object thumbnail, Sticker.Format format) {
        super(BaseResponse.class, "thumbnail", thumbnail);
        add("name", name);
        add("user_id", userId);
        add("format", format);
    }

    public SetStickerSetThumbnail(String name, Long userId, Sticker.Format format) {
        super(BaseResponse.class, "name", name);
        add("user_id", userId);
        add("format", format);
    }

}
