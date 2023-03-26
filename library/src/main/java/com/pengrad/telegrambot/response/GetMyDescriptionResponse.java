package com.pengrad.telegrambot.response;

import java.util.Objects;

import com.pengrad.telegrambot.model.BotDescription;

public class GetMyDescriptionResponse extends BaseResponse {

    private BotDescription result;

    public BotDescription botDescription() {
        return result;
    }

    @Override
    public String toString() {
        return "GetMyDescriptionResponse{" +
                "result=" + Objects.toString(result) +
                '}';
    }
}
