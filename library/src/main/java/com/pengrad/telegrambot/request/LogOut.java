package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.response.BaseResponse;

/**
 * Stas Parshin
 * 05 November 2020
 */
public class LogOut extends BaseRequest<LogOut, BaseResponse> {

    public LogOut() {
        super(BaseResponse.class);
    }
}
