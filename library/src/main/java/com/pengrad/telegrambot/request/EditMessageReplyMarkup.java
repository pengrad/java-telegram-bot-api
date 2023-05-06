package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.impl.TelegramBotClient;
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;
import com.pengrad.telegrambot.response.BaseResponse;
import com.pengrad.telegrambot.response.SendResponse;

/**
 * Stas Parshin
 * 07 May 2016
 */
public class EditMessageReplyMarkup extends BaseRequest<EditMessageReplyMarkup, BaseResponse> {

    public EditMessageReplyMarkup(TelegramBotClient api, Object chatId, int messageId) {
        super(api, SendResponse.class);
        add("chat_id", chatId).add("message_id", messageId);
    }

    public EditMessageReplyMarkup(TelegramBotClient api, String inlineMessageId) {
        super(api, BaseResponse.class);
        add("inline_message_id", inlineMessageId);
    }

    public EditMessageReplyMarkup replyMarkup(InlineKeyboardMarkup replyMarkup) {
        return add("reply_markup", replyMarkup);
    }

}
