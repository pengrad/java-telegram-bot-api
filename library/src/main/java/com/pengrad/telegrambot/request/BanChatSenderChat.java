package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.response.BaseResponse;

/**
 * Mirco Ianese
 * 07 December 2021
 */
public class BanChatSenderChat extends BaseRequest<BanChatSenderChat, BaseResponse> {

    public BanChatSenderChat(Object chatId, long sender_chat_id) {
        super(BaseResponse.class);
        add("chat_id", chatId).add("sender_chat_id", sender_chat_id);
    }
}
