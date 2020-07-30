package com.pengrad.telegrambot.passport;

import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.response.BaseResponse;

/**
 * Stas Parshin
 * 30 July 2018
 */
public class SetPassportDataErrors extends BaseRequest<SetPassportDataErrors, BaseResponse> {

    public SetPassportDataErrors(int userId, PassportElementError... errors) {
        super(BaseResponse.class);
        add("user_id", userId).add("errors", errors);
    }
}
