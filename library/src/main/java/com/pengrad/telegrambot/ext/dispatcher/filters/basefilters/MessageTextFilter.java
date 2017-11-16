package com.pengrad.telegrambot.ext.dispatcher.filters.basefilters;

import com.pengrad.telegrambot.model.Message;
import com.sun.istack.internal.NotNull;

public abstract class MessageTextFilter extends MessageFilter{
    /**
     * @param acceptEdited true if editedMessages should be checked by the filter.
     */
    public MessageTextFilter(boolean acceptEdited) {
        super(acceptEdited);
    }

    @Override
    public boolean filter(Message message) {
        return message.text() != null  && filter(message.text());
    }

    public abstract boolean filter(@NotNull String message);
}
