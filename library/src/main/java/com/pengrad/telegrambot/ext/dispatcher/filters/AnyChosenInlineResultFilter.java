package com.pengrad.telegrambot.ext.dispatcher.filters;

import com.pengrad.telegrambot.ext.dispatcher.filters.basefilters.ChosenInlineResultFilter;
import com.pengrad.telegrambot.model.ChosenInlineResult;

public class AnyChosenInlineResultFilter extends ChosenInlineResultFilter {

    @Override
    public boolean filter(ChosenInlineResult chosenInlineResult) {
        return true;
    }
}
