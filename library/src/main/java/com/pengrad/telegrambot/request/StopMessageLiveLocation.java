package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.impl.TelegramBotClient;
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;
import com.pengrad.telegrambot.response.BaseResponse;
import com.pengrad.telegrambot.response.SendResponse;

/**
 * Stas Parshin
 * 12 October 2017
 */
public class StopMessageLiveLocation extends BaseRequest<StopMessageLiveLocation, BaseResponse> {

    public StopMessageLiveLocation(TelegramBotClient api, Object chatId, int messageId) {
        super(api, SendResponse.class);
        add("chat_id", chatId).add("message_id", messageId);
    }

    public StopMessageLiveLocation(TelegramBotClient api, String inlineMessageId) {
        super(api, BaseResponse.class);
        add("inline_message_id", inlineMessageId);
    }

    public StopMessageLiveLocation replyMarkup(InlineKeyboardMarkup replyMarkup) {
        return add("reply_markup", replyMarkup);
    }
}
