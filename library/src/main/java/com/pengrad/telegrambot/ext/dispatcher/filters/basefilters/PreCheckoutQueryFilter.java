package com.pengrad.telegrambot.ext.dispatcher.filters.basefilters;

import com.pengrad.telegrambot.model.PreCheckoutQuery;
import com.pengrad.telegrambot.model.Update;
import com.sun.istack.internal.NotNull;

public abstract class PreCheckoutQueryFilter implements Filter {
    @Override
    public boolean filter(@NotNull Update update) {
        return update.preCheckoutQuery() != null && filter(update.preCheckoutQuery());
    }

    /**
     * implement this method and add the filter to the Dispatcher to
     * @param preCheckoutQuery the PreCheckoutQuery from a update that needs to be checked
     * @return true if the update should be handled by the UpdatesHandler
     */
    public abstract boolean filter(@NotNull PreCheckoutQuery preCheckoutQuery);
}
