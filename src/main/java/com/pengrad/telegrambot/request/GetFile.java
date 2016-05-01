package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.impl.TelegramApi;
import com.pengrad.telegrambot.response.GetFileResponse;

/**
 * stas
 * 5/1/16.
 */
public class GetFile extends BaseRequest<GetFile, GetFileResponse> {

    public GetFile(TelegramApi api, String fileId) {
        super(api, GetFileResponse.class);
        add("file_id", fileId);
    }

    @Override
    public String getMethod() {
        return "getFile";
    }
}
