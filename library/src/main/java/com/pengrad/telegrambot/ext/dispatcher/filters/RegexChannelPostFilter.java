package com.pengrad.telegrambot.ext.dispatcher.filters;

import com.pengrad.telegrambot.ext.dispatcher.filters.basefilters.ChannelPostTextFilter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexChannelPostFilter extends ChannelPostTextFilter {
    private final Pattern regex;

    /**
     * @param regex the regex that message.text() should match;
     * @param acceptEdited true if editedMessages should be checked by the filter.
     */
    public RegexChannelPostFilter(Pattern regex, boolean acceptEdited) {
        super(acceptEdited);
        this.regex = regex;
    }

    @Override
    public boolean filter(String message) {
        Matcher matcher = regex.matcher(message);
        return matcher.matches();
    }
}