package com.pengrad.telegrambot.ext.dispatcher.filters;

import com.pengrad.telegrambot.ext.dispatcher.filters.basefilters.Filter;
import com.pengrad.telegrambot.model.Update;

public class CombinedFilter <F1 extends Filter, F2 extends Filter> implements Filter {
    private final F2 filter2;
    private final F1 filter1;

    public CombinedFilter(F1 filter1, F2 filter2) {
        this.filter1 = filter1;
        this.filter2 = filter2;
    }

    public boolean filter(Update update) {
        return filter1.filter(update) || filter2.filter(update);
    }
}
