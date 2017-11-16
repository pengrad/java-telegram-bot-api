package com.pengrad.telegrambot.ext.dispatcher.filters;

import com.pengrad.telegrambot.ext.dispatcher.filters.basefilters.Filter;
import com.pengrad.telegrambot.model.Update;

public class InversedFilter <F extends Filter> implements Filter {
    private final F filter;

    public InversedFilter(F filter) {
        this.filter = filter;
    }

    @Override
    public boolean filter(Update update) {
        return !filter.filter(update);
    }
}
