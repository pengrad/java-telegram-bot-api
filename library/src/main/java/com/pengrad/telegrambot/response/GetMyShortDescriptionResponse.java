package com.pengrad.telegrambot.response;

import java.util.Objects;

import com.pengrad.telegrambot.model.BotShortDescription;

public class GetMyShortDescriptionResponse extends BaseResponse {

    private BotShortDescription result;

    public BotShortDescription botShortDescription() {
        return result;
    }

    @Override
    public String toString() {
        return "GetMyShortDescriptionResponse{" +
                "result=" + Objects.toString(result) +
                '}';
    }
}
