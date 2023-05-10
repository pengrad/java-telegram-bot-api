package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.impl.TelegramBotClient;
import com.pengrad.telegrambot.response.BaseResponse;

/**
 * Stas Parshin
 * 23 July 2017
 */
public class DeleteStickerFromSet extends BaseRequest<DeleteStickerFromSet, BaseResponse> {
    public DeleteStickerFromSet(TelegramBotClient api, String sticker) {
        super(api, BaseResponse.class);
        add("sticker", sticker);
    }
}
