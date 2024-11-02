package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.model.MessageEntity;
import com.pengrad.telegrambot.model.request.ReplyParameters;
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

    public CopyMessage messageThreadId(Integer messageThreadId) {
        return add("message_thread_id", messageThreadId);
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

    public CopyMessage replyParameters(ReplyParameters replyParameters) {
        return add("reply_parameters", replyParameters);
    }

    /*
        @deprecated Use replyParameters instead
     */
    public CopyMessage allowSendingWithoutReply(boolean allowSendingWithoutReply) {
        return add("allow_sending_without_reply", allowSendingWithoutReply);
    }

    /*
        @deprecated Use replyParameters instead
    */
    public CopyMessage replyToMessageId(int replyToMessageId) {
        return add("reply_to_message_id", replyToMessageId);
    }

    public CopyMessage replyMarkup(Keyboard replyMarkup) {
        return add("reply_markup", replyMarkup);
    }

    public CopyMessage showCaptionAboveMedia(boolean showCaptionAboveMedia) {
        return add("show_caption_above_media", showCaptionAboveMedia);
    }

    public CopyMessage disableNotification(boolean disableNotification) {
        return add("disable_notification", disableNotification);
    }

    public CopyMessage protectContent(boolean protectContent) {
        return add("protect_content", protectContent);
    }

    public CopyMessage allowPaidBroadcast(boolean allowPaidBroadcast) {
        return add("allow_paid_broadcast", allowPaidBroadcast);
    }

}
