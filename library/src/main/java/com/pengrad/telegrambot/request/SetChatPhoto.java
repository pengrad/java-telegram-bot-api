package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.response.BaseResponse;

import java.io.File;

/**
 * Stas Parshin
 * 01 July 2017
 */
public class SetChatPhoto extends BaseRequest<SetChatPhoto, BaseResponse> {

    public SetChatPhoto(Object chatId, byte[] photo) {
        super(BaseResponse.class);
        add("chat_id", chatId).add("photo", photo);
    }

    public SetChatPhoto(Object chatId, File photo) {
        super(BaseResponse.class);
        add("chat_id", chatId).add("photo", photo);
    }

    @Override
    public boolean isMultipart() {
        return true;
    }
}
