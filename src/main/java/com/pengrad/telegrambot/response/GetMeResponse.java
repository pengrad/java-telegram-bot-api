package com.pengrad.telegrambot.response;

import com.pengrad.telegrambot.model.User;

/**
 * stas
 * 8/4/15.
 */
public class GetMeResponse {
    public final boolean ok;
    public final User result;

    public GetMeResponse(boolean ok, User result) {
        this.ok = ok;
        this.result = result;
    }
}
