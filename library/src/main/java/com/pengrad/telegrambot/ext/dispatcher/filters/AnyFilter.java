package com.pengrad.telegrambot.ext.dispatcher.filters;

import com.pengrad.telegrambot.ext.dispatcher.filters.basefilters.Filter;
import com.pengrad.telegrambot.model.Update;

public class AnyFilter implements Filter {
    @Override
    public boolean filter(Update update) {
        return true;
    }
}
