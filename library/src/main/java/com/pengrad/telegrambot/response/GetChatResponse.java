package com.pengrad.telegrambot.response;

import com.pengrad.telegrambot.model.ChatFullInfo;

/**
 * Stas Parshin
 * 28 May 2016
 */
public class GetChatResponse extends BaseResponse {

    private ChatFullInfo result;

    public ChatFullInfo chat() {
        return result;
    }

    @Override
    public String toString() {
        return "GetChatResponse{" +
                "result=" + result +
                '}';
    }
}
