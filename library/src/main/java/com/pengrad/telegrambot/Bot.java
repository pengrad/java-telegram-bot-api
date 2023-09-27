package com.pengrad.telegrambot;

import com.pengrad.telegrambot.model.File;
import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.request.GetUpdates;
import com.pengrad.telegrambot.response.BaseResponse;

import java.io.IOException;

public interface Bot {
    <T extends BaseRequest<T, R>, R extends BaseResponse> R execute(BaseRequest<T, R> request);

    <T extends BaseRequest<T, R>, R extends BaseResponse> void execute(T request, Callback<T, R> callback);

    String getToken();

    String getFullFilePath(File file);

    byte[] getFileContent(File file) throws IOException;

    void setUpdatesListener(UpdatesListener listener);

    void setUpdatesListener(UpdatesListener listener, GetUpdates request);

    void setUpdatesListener(UpdatesListener listener, ExceptionHandler exceptionHandler);

    void setUpdatesListener(UpdatesListener listener, ExceptionHandler exceptionHandler, GetUpdates request);

    void removeGetUpdatesListener();

    void shutdown();
}
