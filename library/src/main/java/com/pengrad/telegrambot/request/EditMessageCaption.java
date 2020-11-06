package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.model.MessageEntity;
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;
import com.pengrad.telegrambot.model.request.ParseMode;
import com.pengrad.telegrambot.response.BaseResponse;
import com.pengrad.telegrambot.response.SendResponse;

/**
 * Stas Parshin
 * 07 May 2016
 */
public class EditMessageCaption extends BaseRequest<EditMessageCaption, BaseResponse> {

    public EditMessageCaption(Object chatId, int messageId) {
        super(SendResponse.class);
        add("chat_id", chatId).add("message_id", messageId);
    }

    public EditMessageCaption(String inlineMessageId) {
        super(BaseResponse.class);
        add("inline_message_id", inlineMessageId);
    }

    public EditMessageCaption caption(String caption) {
        return add("caption", caption);
    }

    public EditMessageCaption parseMode(ParseMode parseMode) {
        return add("parse_mode", parseMode.name());
    }

    public EditMessageCaption captionEntities(MessageEntity... entities) {
        return add("caption_entities", entities);
    }

    public EditMessageCaption replyMarkup(InlineKeyboardMarkup replyMarkup) {
        return add("reply_markup", replyMarkup);
    }

}
