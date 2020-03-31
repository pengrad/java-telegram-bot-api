package com.pengrad.telegrambot.response;

import com.pengrad.telegrambot.model.BotCommand;

import java.util.Arrays;

/**
 * Stas Parshin
 * 31 March 2020
 */
public class GetMyCommandsResponse extends BaseResponse {

    private BotCommand[] result;

    public BotCommand[] commands() {
        return result;
    }

    @Override
    public String toString() {
        return "GetMyCommandsResponse{" +
                "result=" + Arrays.toString(result) +
                '}';
    }
}
