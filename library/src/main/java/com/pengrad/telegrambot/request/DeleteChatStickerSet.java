package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.impl.TelegramBotClient;
import com.pengrad.telegrambot.response.BaseResponse;

/**
 * Stas Parshin
 * 12 October 2017
 */
public class DeleteChatStickerSet extends BaseRequest<DeleteChatStickerSet, BaseResponse> {

    public DeleteChatStickerSet(TelegramBotClient api, Object chatId) {
        super(api, BaseResponse.class);
        add("chat_id", chatId);
    }
}
