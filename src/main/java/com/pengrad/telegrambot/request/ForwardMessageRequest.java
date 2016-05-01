package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.impl.TelegramApi;
import com.pengrad.telegrambot.response.SendResponse;

/**
 * stas
 * 5/1/16.
 */
public class ForwardMessageRequest extends BaseRequest<ForwardMessageRequest, SendResponse> {

    public ForwardMessageRequest(TelegramApi api, Object chatId, Object fromChatId, int messageId) {
        super(api, SendResponse.class);
        add("chat_id", chatId).add("from_chat_id", fromChatId).add("message_id", messageId);
    }

    public ForwardMessageRequest disableNotification(boolean disableNotification) {
        return add("disable_notification", disableNotification);
    }

    @Override
    public String getMethod() {
        return "forwardMessage";
    }
}
