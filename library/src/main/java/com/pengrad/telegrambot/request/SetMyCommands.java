package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.model.BotCommand;
import com.pengrad.telegrambot.response.BaseResponse;

/**
 * Stas Parshin
 * 31 March 2020
 */
public class SetMyCommands extends BaseRequest<SetMyCommands, BaseResponse> {

    public SetMyCommands(BotCommand... commands) {
        super(BaseResponse.class);
        add("commands", commands);
    }
}
