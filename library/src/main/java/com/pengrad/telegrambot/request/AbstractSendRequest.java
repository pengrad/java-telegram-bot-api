package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.model.request.ReplyParameters;
import com.pengrad.telegrambot.model.request.Keyboard;
import com.pengrad.telegrambot.response.SendResponse;

/**
 * stas
 * 5/1/16.
 */
abstract public class AbstractSendRequest<T extends AbstractSendRequest<T>> extends BaseRequest<T, SendResponse> {

    public AbstractSendRequest(Object chatId) {
        super(SendResponse.class);
        add("chat_id", chatId);
    }

    public T messageEffectId(String messageEffectId) {
        return add("message_effect_id", messageEffectId);
    }

    public T businessConnectionId(String businessConnectionId) {
        return add("business_connection_id", businessConnectionId);
    }

    public T messageThreadId(Integer messageThreadId) {
        return add("message_thread_id", messageThreadId);
    }

    public T disableNotification(boolean disableNotification) {
        return add("disable_notification", disableNotification);
    }

    public T replyParameters(ReplyParameters replyParameters) {
        return add("reply_parameters", replyParameters);
    }

    /*
     @deprecated Use replyParameters instead
    */
    public T replyToMessageId(int replyToMessageId) {
        return add("reply_to_message_id", replyToMessageId);
    }

    /*
        @deprecated Use replyParameters instead
    */
    public T allowSendingWithoutReply(boolean allowSendingWithoutReply) {
        return add("allow_sending_without_reply", allowSendingWithoutReply);
    }

    public T replyMarkup(Keyboard replyMarkup) {
        return add("reply_markup", replyMarkup);
    }

    public T protectContent(boolean protectContent) {
        return add("protect_content", protectContent);
    }

    public T allowPaidBroadcast(boolean allowPaidBroadcast) {
        return add("allow_paid_broadcast", allowPaidBroadcast);
    }

}
