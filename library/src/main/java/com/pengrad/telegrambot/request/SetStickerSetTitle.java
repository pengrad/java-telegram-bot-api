package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.response.BaseResponse;


public class SetStickerSetTitle extends BaseRequest<SetStickerSetTitle, BaseResponse> {

    /**
     * 
     * @param name Sticker set name
     * @param title Sticker set title, 1-64 characters
     */
    public SetStickerSetTitle(String name, String title) {
        super(BaseResponse.class);
        add("name", name);
        add("title", title);
    }

}
