package com.pengrad.telegrambot.ext.dispatcher.filters;

import com.pengrad.telegrambot.ext.dispatcher.filters.basefilters.PreCheckoutQueryFilter;
import com.pengrad.telegrambot.model.PreCheckoutQuery;

public class AnyPreCheckoutQueryFilter extends PreCheckoutQueryFilter {
    @Override
    public boolean filter(PreCheckoutQuery preCheckoutQuery) {
        return true;
    }
}
