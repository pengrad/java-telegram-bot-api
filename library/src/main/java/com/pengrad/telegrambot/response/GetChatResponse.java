package com.pengrad.telegrambot.response;

import com.pengrad.telegrambot.model.Chat;

/**
 * Stas Parshin
 * 28 May 2016
 */
public class GetChatResponse extends BaseResponse {

    private Chat result;

    public Chat chat() {
        return result;
    }

    @Override
    public String toString() {
        return "GetChatResponse{" +
                "result=" + result +
                '}';
    }
}
