package com.pengrad.telegrambot.ext.dispatcher.filters;

import com.pengrad.telegrambot.ext.dispatcher.filters.basefilters.MessageTextFilter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMessageFilter extends MessageTextFilter {
    private final Pattern regex;

    /**
     * @param acceptEdited true if editedMessages should be checked by the filter.
     */
    public RegexMessageFilter(Pattern regex, boolean acceptEdited) {
        super(acceptEdited);
        this.regex = regex;
    }

    @Override
    public boolean filter(String message) {
        Matcher matcher = regex.matcher(message);
        return matcher.matches();
    }
}
