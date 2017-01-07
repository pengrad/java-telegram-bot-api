package com.pengrad.telegrambot.response;

import com.pengrad.telegrambot.model.User;

/**
 * stas
 * 8/4/15.
 */
public class GetMeResponse extends BaseResponse {

    private User result;

    GetMeResponse() {
    }

    public User user() {
        return result;
    }

    @Override
    public String toString() {
        return "GetMeResponse{" +
                "result=" + result +
                '}';
    }
}
