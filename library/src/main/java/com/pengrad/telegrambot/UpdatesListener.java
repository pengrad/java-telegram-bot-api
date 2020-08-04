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
     * @param updates available updates
     * @return id of the last processed update which should not be re-delivered
     * There are 2 convenient values:
     * @see #CONFIRMED_UPDATES_ALL
     * @see #CONFIRMED_UPDATES_NONE
     */
    int process(List<Update> updates);

}
