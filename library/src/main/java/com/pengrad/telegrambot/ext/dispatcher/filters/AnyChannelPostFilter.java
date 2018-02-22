package com.pengrad.telegrambot.ext.dispatcher.filters;

import com.pengrad.telegrambot.ext.dispatcher.filters.basefilters.ChannelPostFilter;
import com.pengrad.telegrambot.model.Message;

public class AnyChannelPostFilter extends ChannelPostFilter {
    /**
     * @param acceptEdited true if editedMessages should be checked by the filter.
     */
    public AnyChannelPostFilter(boolean acceptEdited) {
        super(acceptEdited);
    }

    @Override
    public boolean filter(Message message) {
        return true;
    }
}
