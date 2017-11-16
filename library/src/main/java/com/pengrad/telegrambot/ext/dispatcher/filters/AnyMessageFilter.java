package com.pengrad.telegrambot.ext.dispatcher.filters;

import com.pengrad.telegrambot.ext.dispatcher.filters.basefilters.MessageFilter;
import com.pengrad.telegrambot.model.Message;

public class AnyMessageFilter extends MessageFilter {
    /**
     * @param acceptEdited true if editedMessages should be checked by the filter.
     */
    public AnyMessageFilter(boolean acceptEdited) {
        super(acceptEdited);
    }

    @Override
    public boolean filter(Message message) {
        return true;
    }
}
