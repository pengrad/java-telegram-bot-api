package com.pengrad.telegrambot.impl;

import com.pengrad.telegrambot.ExceptionHandler;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.request.GetUpdates;

/**
 * @author swat1x (Vadim Smyshlyaev)
 * Created at 31.12.2025
 */
public interface UpdatesHandler {

    void start(TelegramBot bot, UpdatesListener listener, ExceptionHandler exceptionHandler, GetUpdates request);

    void stop();

}
