package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.model.MaskPosition;
import com.pengrad.telegrambot.response.BaseResponse;


public class SetStickerMaskPosition extends BaseRequest<SetStickerMaskPosition, BaseResponse> {

    /**
     * 
     * @param sticker File identifier of the sticker
     */
    public SetStickerMaskPosition(String sticker) {
        super(BaseResponse.class);
        add("sticker", sticker);
    }

    /**
     * 
     * @param maskPosition Where the mask should be placed on faces. Omit the parameter to remove the mask position.
     * @return
     */
    public SetStickerMaskPosition maskPosition(MaskPosition maskPosition) {
        add("mask_position", maskPosition);
        return this;
    }

}
