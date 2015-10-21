package com.pengrad.telegrambot.response;

/**
 * stas
 * 8/11/15.
 */
public class SendChatActionResponse {

    private final boolean ok;
    private final boolean result;

    public SendChatActionResponse(boolean ok, boolean result) {
        this.ok = ok;
        this.result = result;
    }

    public boolean isOk() {
        return ok;
    }

    public boolean result() {
        return result;
    }

    @Override
    public String toString() {
        return "SendChatActionResponse{" +
                "ok=" + ok +
                ", result=" + result +
                '}';
    }
}
