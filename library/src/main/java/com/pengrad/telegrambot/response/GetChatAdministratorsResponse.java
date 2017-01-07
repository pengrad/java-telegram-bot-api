package com.pengrad.telegrambot.response;

import com.pengrad.telegrambot.model.ChatMember;

import java.util.List;

/**
 * Stas Parshin
 * 28 May 2016
 */
public class GetChatAdministratorsResponse extends BaseResponse {

    private List<ChatMember> result;

    public List<ChatMember> administrators() {
        return result;
    }

    @Override
    public String toString() {
        return "GetChatAdministratorsResponse{" +
                "result=" + result +
                '}';
    }
}
