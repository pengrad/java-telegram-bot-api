package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.impl.TelegramBotClient;
import com.pengrad.telegrambot.response.BaseResponse;


public class DeleteStickerSet extends BaseRequest<DeleteStickerSet, BaseResponse> {

    /**
     * 
     * @param name Sticker set name
     */
    public DeleteStickerSet(TelegramBotClient api, String name) {
        super(api, BaseResponse.class);
        add("name", name);
    }

}
