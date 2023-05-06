package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.impl.TelegramBotClient;
import com.pengrad.telegrambot.response.BaseResponse;

/**
 * Stas Parshin
 * 01 July 2017
 */
public class PinChatMessage extends BaseRequest<PinChatMessage, BaseResponse> {

    public PinChatMessage(TelegramBotClient api, Object chatId, int messageId) {
        super(api, BaseResponse.class);
        add("chat_id", chatId).add("message_id", messageId);
    }

    public PinChatMessage disableNotification(boolean disableNotification) {
        return add("disable_notification", disableNotification);
    }
}
