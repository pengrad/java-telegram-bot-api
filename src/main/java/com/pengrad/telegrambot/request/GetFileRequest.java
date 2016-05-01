package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.impl.TelegramApi;
import com.pengrad.telegrambot.response.GetFileResponse;
import okhttp3.FormBody;
import okhttp3.RequestBody;

/**
 * stas
 * 5/1/16.
 */
public class GetFileRequest extends BaseRequest<GetFileResponse> {

    private final FormBody.Builder builder;

    public GetFileRequest(TelegramApi api, String fileId) {
        super(api, GetFileResponse.class);
        builder = new FormBody.Builder().add("file_id", fileId);
    }

    @Override
    public String getMethod() {
        return "getFile";
    }

    @Override
    public RequestBody getRequestBody() {
        return builder.build();
    }
}
