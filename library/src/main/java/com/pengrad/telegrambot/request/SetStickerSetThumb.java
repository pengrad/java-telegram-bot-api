package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.impl.TelegramBotClient;
import com.pengrad.telegrambot.response.BaseResponse;

/**
 * Stas Parshin
 * 31 March 2020
 * @deprecated Use SetStickerSetThumbnail instead (since API v6.6)
 */
@Deprecated
public class SetStickerSetThumb extends AbstractUploadRequest<AddStickerToSet, BaseResponse> {

    public SetStickerSetThumb(TelegramBotClient api, String name, Long userId, Object thumb) {
        super(api, BaseResponse.class, "thumb", thumb);
        add("name", name);
        add("user_id", userId);
    }

    public SetStickerSetThumb(TelegramBotClient api, String name, Long userId) {
        super(api, BaseResponse.class, "name", name);
        add("user_id", userId);
    }
}
