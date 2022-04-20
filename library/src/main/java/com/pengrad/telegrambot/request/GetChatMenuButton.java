package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.response.GetChatMenuButtonResponse;

/**
 * Mirco Ianese
 * 20 Apr 2022
 */
public class GetChatMenuButton extends BaseRequest<GetChatMenuButton, GetChatMenuButtonResponse> {
    
    public GetChatMenuButton() {
        super(GetChatMenuButtonResponse.class);
    }

    public GetChatMenuButton chatId(long chatId) {
        return add("chat_id", chatId);
    }

}
