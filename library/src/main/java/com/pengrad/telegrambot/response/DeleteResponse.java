package com.pengrad.telegrambot.response;

import com.pengrad.telegrambot.model.Message;

/**
 * stas
 * 8/5/15.
 */
public class DeleteResponse extends BaseResponse {

    private Boolean result;

    DeleteResponse() {
    }

    public Boolean message() {
        return result;
    }

    @Override
    public String toString() {
        return "SendResponse{" +
                "result=" + result +
                '}';
    }
}
