package com.pengrad.telegrambot.response;

import com.pengrad.telegrambot.model.File;

/**
 * Stas Parshin
 * 16 October 2015
 */
public class GetFileResponse {

    private final boolean ok;
    private final File result;

    public GetFileResponse(boolean ok, File result) {
        this.ok = ok;
        this.result = result;
    }

    public boolean isOk() {
        return ok;
    }

    public File file() {
        return result;
    }

    @Override
    public String toString() {
        return "GetFileResponse{" +
                "ok=" + ok +
                ", result=" + result +
                '}';
    }
}
