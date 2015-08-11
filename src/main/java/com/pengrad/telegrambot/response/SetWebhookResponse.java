package com.pengrad.telegrambot.response;

/**
 * stas
 * 8/11/15.
 */
public class SetWebhookResponse {

    public final boolean ok;
    public final boolean result;
    public final String description;

    public SetWebhookResponse(boolean ok, boolean result, String description) {
        this.ok = ok;
        this.result = result;
        this.description = description;
    }
}