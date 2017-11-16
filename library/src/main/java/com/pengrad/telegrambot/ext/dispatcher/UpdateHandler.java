package com.pengrad.telegrambot.ext.dispatcher;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Update;

/**
 * Add an implementation of this class to the Dispatcher to get the updates that get through the filter.
 */
public interface UpdateHandler {
    /**
     * If a update gets through the filter the dispatcher will call this function.
     *
     * @param bot the bot that received the update.
     * @param update the update that passed the filter.
     * @return false if the this is the last handler to be called.
     */
    boolean handleUpdate(TelegramBot bot, Update update);
}
