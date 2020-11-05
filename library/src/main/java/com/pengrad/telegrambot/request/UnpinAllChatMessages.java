package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.response.BaseResponse;

/**
 * Stas Parshin
 * 05 November 2020
 */
public class UnpinAllChatMessages extends BaseRequest<UnpinAllChatMessages, BaseResponse> {

    public UnpinAllChatMessages(Object chatId) {
        super(BaseResponse.class);
        add("chat_id", chatId);
    }
}
