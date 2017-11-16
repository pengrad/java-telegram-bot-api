package com.pengrad.telegrambot.ext.dispatcher.filters.basefilters;

import com.pengrad.telegrambot.model.Message;

public abstract class ChannelPostTextFilter extends ChannelPostFilter {

    /**
     * @param acceptEdited true if editedMessages should be checked by the filter.
     */
    public ChannelPostTextFilter(boolean acceptEdited) {
        super(acceptEdited);
    }

    @Override
    public boolean filter(Message message) {
        return message.text() != null && filter(message.text());
    }

    public abstract boolean filter(String string);
}
