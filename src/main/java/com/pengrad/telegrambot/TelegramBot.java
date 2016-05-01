package com.pengrad.telegrambot;

import com.pengrad.telegrambot.impl.FileApi;
import com.pengrad.telegrambot.impl.TelegramApi;
import com.pengrad.telegrambot.model.File;
import com.pengrad.telegrambot.model.request.ChatAction;
import com.pengrad.telegrambot.request.GetFile;
import com.pengrad.telegrambot.request.GetMe;
import com.pengrad.telegrambot.request.SendChatAction;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.GetFileResponse;
import com.pengrad.telegrambot.response.GetMeResponse;
import com.pengrad.telegrambot.response.OkResponse;
import com.pengrad.telegrambot.response.SendResponse;

/**
 * Stas Parshin
 * 16 October 2015
 */
public class TelegramBot extends OldTelegramBot {

    private final TelegramApi api;
    private final FileApi fileApi;

    TelegramBot(TelegramApi api, FileApi fileApi) {
        super(api, fileApi);
        this.api = api;
        this.fileApi = fileApi;
    }

    public String getFullFilePath(String fileId) {
        GetFileResponse fileResponse = new GetFile(api, fileId).execute();
        if (!fileResponse.isOk() || fileResponse.file() == null) {
            return null;
        }
        return fileApi.getFullFilePath(fileResponse.file().filePath());
    }

    public String getFullFilePath(File file) {
        return fileApi.getFullFilePath(file.filePath());
    }

    public GetMeResponse getMe() {
        return new GetMe(api).execute();
    }

    public SendResponse sendMessage(Object chatId, String text) {
        return new SendMessage(api, chatId, text).execute();
    }

    public OkResponse sendChatAction(Object chatId, ChatAction action) {
        return new SendChatAction(api, chatId, action.name()).execute();
    }
}
