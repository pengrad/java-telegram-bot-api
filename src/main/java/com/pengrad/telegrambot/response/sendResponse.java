package com.pengrad.telegrambot.response;

import com.pengrad.telegrambot.model.Message;

/**
 * stas
 * 8/5/15.
 */
public class SendResponse {

    public final boolean ok;
    public final Message result;

    public SendResponse(boolean ok, Message result) {
        this.ok = ok;
        this.result = result;
    }
}
