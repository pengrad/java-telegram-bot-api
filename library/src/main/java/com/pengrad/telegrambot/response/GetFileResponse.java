package com.pengrad.telegrambot.response;

import com.pengrad.telegrambot.model.File;

/**
 * Stas Parshin
 * 16 October 2015
 */
public class GetFileResponse extends BaseResponse {

    private File result;

    GetFileResponse() {
    }

    public File file() {
        return result;
    }

    @Override
    public String toString() {
        return "GetFileResponse{" +
                "result=" + result +
                '}';
    }
}
