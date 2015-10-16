package com.pengrad.telegrambot.response;

import com.pengrad.telegrambot.model.File;

/**
 * Stas Parshin
 * 16 October 2015
 */
public class GetFileResponse {

    public final boolean ok;
    public final File result;

    public GetFileResponse(boolean ok, File result) {
        this.ok = ok;
        this.result = result;
    }
}
