package com.pengrad.telegrambot.response;

import com.pengrad.telegrambot.model.MenuButton;
import com.pengrad.telegrambot.model.MenuButtonWebApp;

/**
 * Mirco Ianese
 * 20 Apr 2022
 */
public class GetChatMenuButtonResponse extends BaseResponse {
    
    private MenuButton result;

    public MenuButton result() {
        return result;
    }
    
    @Override
    public String toString() {
        return "GetChatMenuButtonResponse{" +
                "result=" + result +
                '}';
    }

}
