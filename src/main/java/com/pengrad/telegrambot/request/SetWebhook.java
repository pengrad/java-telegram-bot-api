package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.response.BaseResponse;

import java.io.File;

/**
 * stas
 * 5/2/16.
 */
public class SetWebhook extends BaseRequest<SetWebhook> {

    private boolean isMultipart = false;

    public SetWebhook() {
        super(BaseResponse.class);
    }

    public SetWebhook url(String url) {
        return add("url", url);
    }

    public SetWebhook certificate(byte[] certificate) {
        isMultipart = true;
        return add("certificate", certificate);
    }

    public SetWebhook certificate(File certificate) {
        isMultipart = true;
        return add("certificate", certificate);
    }

    @Override
    public boolean isMultipart() {
        return isMultipart;
    }
}
