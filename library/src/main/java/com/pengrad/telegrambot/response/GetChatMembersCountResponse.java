package com.pengrad.telegrambot.response;

/**
 * Stas Parshin
 * 29 May 2016
 */
public class GetChatMembersCountResponse extends BaseResponse {

    private int result;

    public int count() {
        return result;
    }

    @Override
    public String toString() {
        return "GetChatMembersCountResponse{" +
                "result=" + result +
                '}';
    }
}
