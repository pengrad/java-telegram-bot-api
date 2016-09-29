package com.pengrad.telegrambot;

import com.pengrad.telegrambot.model.Update;

import java.util.List;

/**
 * Stas Parshin
 * 29 September 2016
 */
public interface GetUpdatesListener {

    int CONFIRMED_UPDATES_ALL = -1;
    int CONFIRMED_UPDATES_NONE = -2;

    int process(List<Update> updates);

}
