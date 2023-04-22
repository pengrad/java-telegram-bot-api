package com.pengrad.telegrambot.response;

import java.util.Objects;

import com.pengrad.telegrambot.model.BotName;

public class GetMyNameResponse extends BaseResponse {

    private BotName result;

    public BotName botName() {
        return result;
    }

    @Override
    public String toString() {
        return "GetMyNameResponse{" +
                "result=" + Objects.toString(result) +
                '}';
    }
}
