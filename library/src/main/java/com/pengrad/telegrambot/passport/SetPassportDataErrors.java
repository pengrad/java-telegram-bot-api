package com.pengrad.telegrambot.passport;

import com.pengrad.telegrambot.impl.TelegramBotClient;
import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.response.BaseResponse;

/**
 * Stas Parshin
 * 30 July 2018
 */
public class SetPassportDataErrors extends BaseRequest<SetPassportDataErrors, BaseResponse> {

    public SetPassportDataErrors(TelegramBotClient api, long userId, PassportElementError... errors) {
        super(api, BaseResponse.class);
        add("user_id", userId).add("errors", errors);
    }
}
