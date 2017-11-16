package com.pengrad.telegrambot.ext.dispatcher.filters;

import com.pengrad.telegrambot.ext.dispatcher.filters.basefilters.CallbackQueryFilter;
import com.pengrad.telegrambot.model.CallbackQuery;

public class AnyCallbackQueryFilter  extends CallbackQueryFilter {
    @Override
    public boolean filter(CallbackQuery callbackQuery) {
        return true;
    }
}
