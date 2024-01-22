package com.pengrad.telegrambot.response;

import com.pengrad.telegrambot.model.chatboost.ChatBoost;

import java.util.Arrays;

public class UserChatBoostsResponse extends BaseResponse {

    private ChatBoost[] boosts;

    public ChatBoost[] boosts() {
        return boosts;
    }

    @Override
    public String toString() {
        return "UserChatBoostsResponse{" +
            "boosts=" + Arrays.toString(boosts) +
            '}';
    }
}
