package com.pengrad.telegrambot;

import com.pengrad.telegrambot.request.BaseRequest;

import java.io.IOException;

/**
 * stas
 * 5/3/16.
 */
public interface Callback<T extends BaseRequest, R> {

    void onResponse(T request, R response);

    void onFailure(T request, IOException e);
}
