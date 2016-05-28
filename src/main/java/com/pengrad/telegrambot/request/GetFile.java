package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.response.GetFileResponse;

/**
 * stas
 * 5/1/16.
 */
public class GetFile extends BaseRequest<GetFile> {

    public GetFile(String fileId) {
        super(GetFileResponse.class);
        add("file_id", fileId);
    }
}
