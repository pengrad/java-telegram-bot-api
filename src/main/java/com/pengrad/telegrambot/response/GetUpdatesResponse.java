package com.pengrad.telegrambot.response;

import com.pengrad.telegrambot.model.Update;

import java.util.List;

/**
 * stas
 * 8/11/15.
 */
public class GetUpdatesResponse {

    private boolean ok;
    private List<Update> result;

    GetUpdatesResponse() {
    }

    public boolean isOk() {
        return ok;
    }

    public List<Update> updates() {
        return result;
    }

    @Override
    public String toString() {
        return "GetUpdatesResponse{" +
                "ok=" + ok +
                ", result=" + result +
                '}';
    }
}