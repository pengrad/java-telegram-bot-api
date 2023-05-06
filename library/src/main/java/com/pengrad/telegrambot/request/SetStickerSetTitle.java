package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.impl.TelegramBotClient;
import com.pengrad.telegrambot.response.BaseResponse;


public class SetStickerSetTitle extends BaseRequest<SetStickerSetTitle, BaseResponse> {

    /**
     * 
     * @param name Sticker set name
     * @param title Sticker set title, 1-64 characters
     */
    public SetStickerSetTitle(TelegramBotClient api, String name, String title) {
        super(api, BaseResponse.class);
        add("name", name);
        add("title", title);
    }

}
