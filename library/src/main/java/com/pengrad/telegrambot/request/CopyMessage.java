package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.model.MessageEntity;
import com.pengrad.telegrambot.model.request.Keyboard;
import com.pengrad.telegrambot.model.request.ParseMode;
import com.pengrad.telegrambot.response.MessageIdResponse;

/**
 * Stas Parshin
 * 06 November 2020
 */
public class CopyMessage extends BaseRequest<CopyMessage, MessageIdResponse> {

    public CopyMessage(Object chatId, Object fromChatId, int messageId) {
        super(MessageIdResponse.class);
        add("chat_id", chatId).add("from_chat_id", fromChatId).add("message_id", messageId);
    }

    public CopyMessage caption(String caption) {
        return add("caption", caption);
    }

    public CopyMessage parseMode(ParseMode parseMode) {
        return add("parse_mode", parseMode.name());
    }

    public CopyMessage captionEntities(MessageEntity... entities) {
        return add("caption_entities", entities);
    }

    public CopyMessage disableNotification(boolean disableNotification) {
        return add("disable_notification", disableNotification);
    }

    public CopyMessage allowSendingWithoutReply(boolean allowSendingWithoutReply) {
        return add("allow_sending_without_reply", allowSendingWithoutReply);
    }

    public CopyMessage replyToMessageId(int replyToMessageId) {
        return add("reply_to_message_id", replyToMessageId);
    }

    public CopyMessage replyMarkup(Keyboard replyMarkup) {
        return add("reply_markup", replyMarkup);
    }

}
