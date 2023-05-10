package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.impl.TelegramBotClient;
import com.pengrad.telegrambot.response.BaseResponse;

/**
 * Stas Parshin
 * 05 November 2020
 */
public class Close extends BaseRequest<Close, BaseResponse> {

    public Close(TelegramBotClient api) {
        super(api, BaseResponse.class);
    }
}
