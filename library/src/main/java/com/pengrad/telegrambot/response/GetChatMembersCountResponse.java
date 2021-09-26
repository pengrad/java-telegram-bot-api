package com.pengrad.telegrambot.response;

/**
 * Stas Parshin
 * 29 May 2016
 * 
 * @deprecated from BOT API v5.3 you should use getChatMemberCount instead, which returns a GetChatMemberCountResponse object
 */

@Deprecated
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
