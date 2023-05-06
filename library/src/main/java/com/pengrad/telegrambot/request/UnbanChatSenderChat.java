package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.impl.TelegramBotClient;
import com.pengrad.telegrambot.response.BaseResponse;

/**
 * Mirco Ianese
 * 07 December 2021
 */
public class UnbanChatSenderChat extends BaseRequest<UnbanChatSenderChat, BaseResponse> {

    public UnbanChatSenderChat(TelegramBotClient api, Object chatId, long sender_chat_id) {
        super(api, BaseResponse.class);
        add("chat_id", chatId).add("sender_chat_id", sender_chat_id);
    }

}
