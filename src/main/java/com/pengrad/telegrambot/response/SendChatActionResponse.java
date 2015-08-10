package com.pengrad.telegrambot.response;

/**
 * stas
 * 8/11/15.
 */
public class SendChatActionResponse {

    public final boolean ok;
    public final boolean result;

    public SendChatActionResponse(boolean ok, boolean result) {
        this.ok = ok;
        this.result = result;
    }
}
