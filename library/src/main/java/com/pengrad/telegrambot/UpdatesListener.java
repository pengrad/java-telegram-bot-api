package com.pengrad.telegrambot;

import com.pengrad.telegrambot.model.Update;

import java.util.List;

/**
 * Stas Parshin
 * 02 November 2016
 */
public interface UpdatesListener {

    int CONFIRMED_UPDATES_ALL = -1;
    int CONFIRMED_UPDATES_NONE = -2;

    /**
     * Callback handler with available updates
     *
     * @param updates the available updated
     * @return The number of processed Updates:
     *  There are 2 convienient values:
     *      @see com.pengrad.telegrambot.UpdatesListener#CONFIRMED_UPDATES_ALL
     *      @see com.pengrad.telegrambot.UpdatesListener#CONFIRMED_UPDATES_NONE
     */
    int process(List<Update> updates);

}
