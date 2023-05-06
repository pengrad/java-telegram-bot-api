package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.impl.TelegramBotClient;
import com.pengrad.telegrambot.response.BaseResponse;

/**
 * Mirco Ianese
 * 17 Nov 2021
 */
public class DeclineChatJoinRequest extends BaseRequest<DeclineChatJoinRequest, BaseResponse> {
    
    /**
     * 
     * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param userId Unique identifier of the target user
     */
    public DeclineChatJoinRequest(TelegramBotClient api, Object chatId, Long userId) {
        super(api, BaseResponse.class);
        add("chat_id", chatId);
        add("user_id", userId);
    }

}
