package com.pengrad.telegrambot.ext.dispatcher.filters.basefilters;

import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.Update;
import com.sun.istack.internal.NotNull;

public abstract class MessageFilter  implements Filter {

    private final boolean acceptEdited;

    /**
     * @param acceptEdited true if editedMessages should be checked by the filter.
     */
    public MessageFilter(boolean acceptEdited){
        this.acceptEdited = acceptEdited;
    }

    public boolean filter(@NotNull Update update) {

        if (update.editedMessage() != null && acceptEdited) {
            return filter(update.editedMessage());
        } else if (update.message() != null) {
            return filter(update.message());
        } else  return false;
    }

    /**
     * implement this method and add the filter to the Dispatcher to
     * @param message the message from a update that needs to be checked
     * @return true if the update should be handled by the UpdatesHandler
     */
    public abstract boolean filter(@NotNull Message message);
}
