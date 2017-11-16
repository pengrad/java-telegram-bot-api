package com.pengrad.telegrambot.ext.dispatcher.filters.basefilters;

import com.pengrad.telegrambot.model.ChosenInlineResult;
import com.pengrad.telegrambot.model.Update;
import com.sun.istack.internal.NotNull;

public abstract class ChosenInlineResultFilter implements Filter {
    @Override
    public boolean filter(@NotNull Update update) {
        return update.chosenInlineResult() != null && filter(update.chosenInlineResult());
    }

    /**
     * implement this method and add the filter to the Dispatcher to
     * @param chosenInlineResult the ChosenInlineResult from a update that needs to be checked
     * @return true if the update should be handled by the UpdatesHandler
     */
    public abstract boolean filter(@NotNull ChosenInlineResult chosenInlineResult);
}
