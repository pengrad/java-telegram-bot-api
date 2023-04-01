package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.response.BaseResponse;


public class DeleteStickerSet extends BaseRequest<DeleteStickerSet, BaseResponse> {

    /**
     * 
     * @param name Sticker set name
     */
    public DeleteStickerSet(String name) {
        super(BaseResponse.class);
        add("name", name);
    }

}
