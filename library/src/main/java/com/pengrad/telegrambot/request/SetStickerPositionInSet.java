package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.response.BaseResponse;

/**
 * Stas Parshin
 * 23 July 2017
 */
public class SetStickerPositionInSet extends BaseRequest<SetStickerPositionInSet, BaseResponse> {

    public SetStickerPositionInSet(String sticker, int position) {
        super(BaseResponse.class);
        add("sticker", sticker).add("position", position);
    }
}
