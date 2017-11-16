package com.pengrad.telegrambot.ext.dispatcher.filters.basefilters;

import com.pengrad.telegrambot.model.CallbackQuery;
import com.pengrad.telegrambot.model.Update;
import com.sun.istack.internal.NotNull;

public abstract class CallbackQueryFilter implements Filter {

    @Override
    public boolean filter(@NotNull Update update) {
        return update.callbackQuery() != null && filter(update.callbackQuery());
    }

    /**
     * implement this method and add the filter to the Dispatcher to
     * @param callbackQuery the callbackQuery from a update that needs to be checked
     * @return true if the update should be handled by the UpdatesHandler
     */
    public abstract boolean filter(@NotNull CallbackQuery callbackQuery);
}
