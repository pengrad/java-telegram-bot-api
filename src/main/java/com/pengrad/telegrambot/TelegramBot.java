package com.pengrad.telegrambot;

import com.pengrad.telegrambot.impl.FileApi;
import com.pengrad.telegrambot.impl.TelegramBotClient;
import com.pengrad.telegrambot.model.File;
import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.response.BaseResponse;

/**
 * Stas Parshin
 * 16 October 2015
 */
public class TelegramBot extends OldTelegramBot {

    private final TelegramBotClient api;
    private final FileApi fileApi;

    TelegramBot(TelegramBotClient api, FileApi fileApi) {
        super(fileApi);
        this.api = api;
        this.fileApi = fileApi;
    }

    public String getFullFilePath(File file) {
        return fileApi.getFullFilePath(file.filePath());
    }

    @Override
    public <T extends BaseRequest, R extends BaseResponse> R execute(BaseRequest<T, R> request) {
        return api.send(request);
    }

    public <T extends BaseRequest<T, R>, R extends BaseResponse> void execute(T request, Callback<T, R> callback) {
        api.send(request, callback);
    }
}
