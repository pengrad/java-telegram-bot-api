package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.impl.TelegramApi;
import com.pengrad.telegrambot.response.GetMeResponse;

/**
 * stas
 * 5/1/16.
 */
public class GetMe extends BaseRequest<GetMe, GetMeResponse> {

    public GetMe(TelegramApi api) {
        super(api, GetMeResponse.class);
    }
}
