package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.impl.TelegramBotClient;
import com.pengrad.telegrambot.response.BaseResponse;


public class SetStickerKeywords extends BaseRequest<SetStickerKeywords, BaseResponse> {

    /**
     * 
     * @param sticker File identifier of the sticker
     */
    public SetStickerKeywords(TelegramBotClient api, String sticker) {
        super(api, BaseResponse.class);
        add("sticker", sticker);
    }

    /**
     * 
     * @param keywords A list of 0-20 search keywords for the sticker with total length of up to 64 characters
     * @return
     */
    public SetStickerKeywords keywords(String[] keywords) {
        add("keywords", keywords);
        return this;
    }

}
