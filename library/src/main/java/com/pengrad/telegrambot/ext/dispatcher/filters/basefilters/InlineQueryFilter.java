package com.pengrad.telegrambot.ext.dispatcher.filters.basefilters;

import com.pengrad.telegrambot.model.InlineQuery;
import com.pengrad.telegrambot.model.Update;
import com.sun.istack.internal.NotNull;

public abstract class InlineQueryFilter  implements Filter{
    @Override
    public boolean filter(@NotNull Update update) {
        return update.inlineQuery() != null && filter(update.inlineQuery());
    }

    /**
     * implement this method and add the filter to the Dispatcher to
     * @param inlineQuery the inlineQuery from a update that needs to be checked
     * @return true if the update should be handled by the UpdatesHandler
     */
    public abstract boolean filter(@NotNull InlineQuery inlineQuery);
}
