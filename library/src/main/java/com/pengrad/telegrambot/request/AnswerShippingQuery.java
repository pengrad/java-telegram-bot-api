package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.model.request.ShippingOption;
import com.pengrad.telegrambot.response.BaseResponse;

/**
 * Stas Parshin
 * 25 May 2017
 */
public class AnswerShippingQuery extends BaseRequest<AnswerShippingQuery, BaseResponse> {

    public AnswerShippingQuery(String shippingQueryId, ShippingOption... shippingOptions) {
        super(BaseResponse.class);
        add("shipping_query_id", shippingQueryId).add("ok", true).add("shipping_options", shippingOptions);
    }

    public AnswerShippingQuery(String shippingQueryId, String errorMessage) {
        super(BaseResponse.class);
        add("shipping_query_id", shippingQueryId).add("ok", false).add("error_message", errorMessage);
    }
}
