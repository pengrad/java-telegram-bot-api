package com.pengrad.telegrambot.response;

import com.pengrad.telegrambot.model.Gift;
import com.pengrad.telegrambot.model.Gifts;

import java.util.Arrays;

public class GetAvailableGiftsResponse extends BaseResponse {
    private Gifts result;

    public Gifts gifts() {
        return result;
    }

    @Override
    public String toString() {
        return "GetAvailableGiftsResponse{" +
            "result=" + result +
            '}';
    }
}
