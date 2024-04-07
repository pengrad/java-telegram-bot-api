package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.model.request.InputSticker;
import com.pengrad.telegrambot.response.BaseResponse;

public class ReplaceStickerInSet extends BaseRequest<ReplaceStickerInSet, BaseResponse> {

    public ReplaceStickerInSet(Long userId, String name, String oldSticker, InputSticker sticker) {
        super(BaseResponse.class);
        add("user_id", userId);
        add("name", name);
        add("old_sticker", oldSticker);
        add("sticker", sticker);
    }

}
