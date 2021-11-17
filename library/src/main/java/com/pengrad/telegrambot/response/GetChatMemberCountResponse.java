package com.pengrad.telegrambot.response;

public class GetChatMemberCountResponse extends BaseResponse {

    private int result;

    public int count() {
        return result;
    }

    @Override
    public String toString() {
        return "GetChatMemberCountResponse{" +
                "result=" + result +
                '}';
    }
}
