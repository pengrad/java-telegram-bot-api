package com.pengrad.telegrambot.response;

/**
 * stas
 * 1/13/16.
 */
public class OkResponse {

    private boolean ok;
    private boolean result;

    OkResponse() {
    }

    public boolean isOk() {
        return ok;
    }

    public boolean result() {
        return result;
    }

    @Override
    public String toString() {
        return "OkResponse{" +
                "ok=" + ok +
                ", result=" + result +
                '}';
    }
}
