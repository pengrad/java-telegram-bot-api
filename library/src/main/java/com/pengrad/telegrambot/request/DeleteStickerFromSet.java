package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.response.BaseResponse;

/**
 * Stas Parshin
 * 23 July 2017
 */
public class DeleteStickerFromSet extends BaseRequest<DeleteStickerFromSet, BaseResponse> {
    public DeleteStickerFromSet(String sticker) {
        super(BaseResponse.class);
        add("sticker", sticker);
    }
}
