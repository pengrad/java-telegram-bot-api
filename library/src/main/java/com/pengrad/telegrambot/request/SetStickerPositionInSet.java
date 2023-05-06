package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.impl.TelegramBotClient;
import com.pengrad.telegrambot.response.BaseResponse;

/**
 * Stas Parshin
 * 23 July 2017
 */
public class SetStickerPositionInSet extends BaseRequest<SetStickerPositionInSet, BaseResponse> {

    public SetStickerPositionInSet(TelegramBotClient api, String sticker, int position) {
        super(api, BaseResponse.class);
        add("sticker", sticker).add("position", position);
    }
}
