package com.pengrad.telegrambot;

import com.pengrad.telegrambot.impl.FileApi;
import com.pengrad.telegrambot.impl.GetUpdatesHandler;
import com.pengrad.telegrambot.impl.TelegramBotClient;
import com.pengrad.telegrambot.model.File;
import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.request.GetUpdates;
import com.pengrad.telegrambot.response.BaseResponse;

/**
 * Stas Parshin
 * 16 October 2015
 */
public class TelegramBot extends OldTelegramBot {

    private final TelegramBotClient api;
    private final FileApi fileApi;
    private final GetUpdatesHandler getUpdatesHandler;

    TelegramBot(TelegramBotClient api, FileApi fileApi) {
        super(fileApi);
        this.api = api;
        this.fileApi = fileApi;
        this.getUpdatesHandler = new GetUpdatesHandler();
    }

    @Override
    public <T extends BaseRequest, R extends BaseResponse> R execute(BaseRequest<T, R> request) {
        return api.send(request);
    }

    public <T extends BaseRequest<T, R>, R extends BaseResponse> void execute(T request, Callback<T, R> callback) {
        api.send(request, callback);
    }

    public String getFullFilePath(File file) {
        return fileApi.getFullFilePath(file.filePath());
    }

    public void setGetUpdatetsListener(GetUpdatesListener listener) {
        setGetUpdatetsListener(listener, new GetUpdates());
    }

    public void setGetUpdatetsListener(GetUpdatesListener listener, GetUpdates request) {
        getUpdatesHandler.start(this, listener, request);
    }

    public void removeGetUpdatesListener() {
        getUpdatesHandler.stop();
    }
}
