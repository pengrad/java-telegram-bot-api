package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.impl.TelegramApi;
import com.pengrad.telegrambot.response.GetMeResponse;

/**
 * stas
 * 5/1/16.
 */
public class GetMeRequest extends BaseRequest<GetMeRequest, GetMeResponse> {

    public GetMeRequest(TelegramApi api) {
        super(api, GetMeResponse.class);
    }

    @Override
    public String getMethod() {
        return "getMe";
    }
}
