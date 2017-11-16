package com.pengrad.telegrambot.ext.dispatcher.filters;

import com.pengrad.telegrambot.ext.dispatcher.filters.basefilters.MessageFilter;
import com.pengrad.telegrambot.model.Message;
import com.sun.istack.internal.NotNull;

public class LocationFilter extends MessageFilter {
    public LocationFilter(boolean acceptEdited) {
        super(acceptEdited);
    }

    @Override
    public boolean filter(@NotNull Message message) {
        return message.location() != null;
    }


}
