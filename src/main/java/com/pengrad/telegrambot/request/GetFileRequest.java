package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.impl.TelegramApi;
import com.pengrad.telegrambot.response.GetFileResponse;

/**
 * stas
 * 5/1/16.
 */
public class GetFileRequest extends BaseRequest<GetFileRequest, GetFileResponse> {

    public GetFileRequest(TelegramApi api, String fileId) {
        super(api, GetFileResponse.class);
        getParameters().put("file_id", fileId);
    }

    @Override
    public String getMethod() {
        return "getFile";
    }
}
