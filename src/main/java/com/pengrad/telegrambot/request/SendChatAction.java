package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.response.BaseResponse;

/**
 * stas
 * 5/2/16.
 */
public class SendChatAction extends BaseRequest<SendChatAction> {

    public SendChatAction(Object chatId, String action) {
        super(BaseResponse.class);
        add("chat_id", chatId).add("action", action);
    }
}
