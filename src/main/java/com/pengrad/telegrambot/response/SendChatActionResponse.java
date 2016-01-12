package com.pengrad.telegrambot.response;

/**
 * stas
 * 8/11/15.
 */
public class SendChatActionResponse {

    private boolean ok;
    private boolean result;

    SendChatActionResponse() {
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
