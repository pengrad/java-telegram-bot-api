package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.impl.TelegramBotClient;
import com.pengrad.telegrambot.model.MenuButton;
import com.pengrad.telegrambot.response.BaseResponse;

/**
 * Mirco Ianese
 * 20 Apr 2022
 */
public class SetChatMenuButton extends BaseRequest<SetChatMenuButton, BaseResponse> {
 
    public SetChatMenuButton(TelegramBotClient api) {
        super(api, BaseResponse.class);
    }

    public SetChatMenuButton chatId(long chatId) {
        return add("chat_id", chatId);
    }

    public SetChatMenuButton menuButton(MenuButton menuButton) {
        return add("menu_button", menuButton);
    }

}
