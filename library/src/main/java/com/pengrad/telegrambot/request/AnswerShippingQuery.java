package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.impl.TelegramBotClient;
import com.pengrad.telegrambot.model.request.ShippingOption;
import com.pengrad.telegrambot.response.BaseResponse;

/**
 * Stas Parshin
 * 25 May 2017
 */
public class AnswerShippingQuery extends BaseRequest<AnswerShippingQuery, BaseResponse> {

    public AnswerShippingQuery(TelegramBotClient api, String shippingQueryId, ShippingOption... shippingOptions) {
        super(api, BaseResponse.class);
        add("shipping_query_id", shippingQueryId).add("ok", true).add("shipping_options", shippingOptions);
    }

    public AnswerShippingQuery(TelegramBotClient api, String shippingQueryId, String errorMessage) {
        super(api, BaseResponse.class);
        add("shipping_query_id", shippingQueryId).add("ok", false).add("error_message", errorMessage);
    }
}
