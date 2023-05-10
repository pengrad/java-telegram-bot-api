package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.impl.TelegramBotClient;
import com.pengrad.telegrambot.response.BaseResponse;

/**
 * Stas Parshin
 * 31 March 2020
 */
public class SetStickerSetThumbnail extends AbstractUploadRequest<AddStickerToSet, BaseResponse> {

    public SetStickerSetThumbnail(TelegramBotClient api, String name, Long userId, Object thumbnail) {
        super(api, BaseResponse.class, "thumbnail", thumbnail);
        add("name", name);
        add("user_id", userId);
    }

    public SetStickerSetThumbnail(TelegramBotClient api, String name, Long userId) {
        super(api, BaseResponse.class, "name", name);
        add("user_id", userId);
    }
}
