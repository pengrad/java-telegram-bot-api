package com.pengrad.telegrambot.response;

import com.pengrad.telegrambot.model.WebhookInfo;

/**
 * Stas Parshin
 * 03 October 2016
 */
public class GetWebhookInfoResponse extends BaseResponse {

    private WebhookInfo result;

    public WebhookInfo webhookInfo() {
        return result;
    }

    @Override
    public String toString() {
        return "GetWebhookInfoResponse{" +
                "result=" + result +
                '}';
    }
}
