package com.pengrad.telegrambot.response;

/**
 * stas
 * 8/11/15.
 */
public class SetWebhookResponse {

    private boolean ok;
    private boolean result;
    private String description;

    SetWebhookResponse() {
    }

    public boolean isOk() {
        return ok;
    }

    public boolean result() {
        return result;
    }

    public String description() {
        return description;
    }

    @Override
    public String toString() {
        return "SetWebhookResponse{" +
                "ok=" + ok +
                ", result=" + result +
                ", description='" + description + '\'' +
                '}';
    }
}