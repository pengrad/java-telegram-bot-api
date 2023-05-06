package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.impl.TelegramBotClient;
import com.pengrad.telegrambot.response.BaseResponse;

/**
 * Stas Parshin
 * 26 May 2017
 */
public class AnswerPreCheckoutQuery extends BaseRequest<AnswerPreCheckoutQuery, BaseResponse> {

    public AnswerPreCheckoutQuery(TelegramBotClient api, String preCheckoutQueryId) {
        super(api, BaseResponse.class);
        add("pre_checkout_query_id", preCheckoutQueryId).add("ok", true);
    }

    public AnswerPreCheckoutQuery(TelegramBotClient api, String preCheckoutQueryId, String errorMessage) {
        super(api, BaseResponse.class);
        add("pre_checkout_query_id", preCheckoutQueryId).add("ok", false).add("error_message", errorMessage);
    }
}
