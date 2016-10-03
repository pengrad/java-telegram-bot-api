package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.response.GetWebhookInfoResponse;

/**
 * Stas Parshin
 * 03 October 2016
 */
public class GetWebhookInfo extends BaseRequest<GetWebhookInfo, GetWebhookInfoResponse> {

    public GetWebhookInfo() {
        super(GetWebhookInfoResponse.class);
    }

}
