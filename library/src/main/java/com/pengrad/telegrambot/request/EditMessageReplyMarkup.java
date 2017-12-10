package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;
import com.pengrad.telegrambot.response.BaseResponse;
import com.pengrad.telegrambot.response.SendResponse;

/**
 * Stas Parshin
 * 07 May 2016
 */
public class EditMessageReplyMarkup extends BaseRequest<EditMessageReplyMarkup, BaseResponse> {

    public EditMessageReplyMarkup(Object chatId, int messageId) {
        super(SendResponse.class);
        add("chat_id", chatId).add("message_id", messageId);
    }

    public EditMessageReplyMarkup(String inlineMessageId) {
        super(BaseResponse.class);
        add("inline_message_id", inlineMessageId);
    }

    /**
     * @deprecated Use EditMessageReplyMarkup(Object chatId, int messageId)
     */
    @Deprecated
    public EditMessageReplyMarkup(Object chatId, int messageId, String text) {
        this(chatId, messageId);
    }

    /**
     * @deprecated Use EditMessageReplyMarkup(String inlineMessageId)
     */
    @Deprecated
    public EditMessageReplyMarkup(String inlineMessageId, String text) {
        this(inlineMessageId);
    }

    public EditMessageReplyMarkup replyMarkup(InlineKeyboardMarkup replyMarkup) {
        return add("reply_markup", replyMarkup);
    }

}
