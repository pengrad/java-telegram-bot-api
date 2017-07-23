package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.response.GetStickerSetResponse;

/**
 * Stas Parshin
 * 23 July 2017
 */
public class GetStickerSet extends BaseRequest<GetStickerSet, GetStickerSetResponse> {

    public GetStickerSet(String name) {
        super(GetStickerSetResponse.class);
        add("name", name);
    }
}
