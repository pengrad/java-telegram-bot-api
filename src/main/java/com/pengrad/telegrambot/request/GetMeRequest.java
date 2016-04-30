package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.impl.TelegramApi;
import com.pengrad.telegrambot.response.GetMeResponse;
import okhttp3.FormBody;
import okhttp3.RequestBody;

/**
 * stas
 * 5/1/16.
 */
public class GetMeRequest extends BaseRequest<GetMeResponse> {

    public GetMeRequest(TelegramApi api) {
        super(api, GetMeResponse.class);
    }

    @Override
    public String getMethod() {
        return "getMe";
    }

    @Override
    public RequestBody getRequestBody() {
        return new FormBody.Builder().build();
    }
}
