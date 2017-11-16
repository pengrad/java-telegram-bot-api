package com.pengrad.telegrambot.ext.dispatcher.filters;

import com.pengrad.telegrambot.ext.dispatcher.filters.basefilters.InlineQueryFilter;
import com.pengrad.telegrambot.model.InlineQuery;

public class AnyInlineQueryFilter extends InlineQueryFilter {
    @Override
    public boolean filter(InlineQuery inlineQuery) {
        return true;
    }
}
