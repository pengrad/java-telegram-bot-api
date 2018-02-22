package com.pengrad.telegrambot.ext.dispatcher.filters;

import com.pengrad.telegrambot.ext.dispatcher.filters.basefilters.MessageFilter;
import com.pengrad.telegrambot.model.Message;

public class CommandFilter extends MessageFilter {
    private final String command;

    public CommandFilter(String command, boolean acceptEdited){
        super(acceptEdited);
        this.command = "/" + command;
    }

    @Override
    public boolean filter(Message message) {
        if (message != null){
            if (message.text() != null){
                return message.text().startsWith(this.command);
            }
        }
        return false;
    }
}
