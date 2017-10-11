package com.pengrad.telegrambot.impl;

import com.pengrad.telegrambot.Callback;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.GetUpdates;
import com.pengrad.telegrambot.response.GetUpdatesResponse;

import java.io.IOException;
import java.util.List;

import static com.pengrad.telegrambot.UpdatesListener.CONFIRMED_UPDATES_ALL;
import static com.pengrad.telegrambot.UpdatesListener.CONFIRMED_UPDATES_NONE;

/**
 * Stas Parshin
 * 29 September 2016
 */
public class UpdatesHandler {

    private TelegramBot bot;
    private UpdatesListener listener;

    private final long sleepTimeout;

    public UpdatesHandler(long sleepTimeout) {
        this.sleepTimeout = sleepTimeout;
    }

    public void start(TelegramBot bot, UpdatesListener listener, GetUpdates request) {
        this.bot = bot;
        this.listener = listener;
        getUpdates(request);
    }

    public void stop() {
        bot = null;
        listener = null;
    }

    private void getUpdates(GetUpdates request) {
        if (bot == null || listener == null) return;

        bot.execute(request, new Callback<GetUpdates, GetUpdatesResponse>() {
            @Override
            public void onResponse(GetUpdates request, GetUpdatesResponse response) {
                if (listener == null) return;

                if (!response.isOk() || response.updates() == null || response.updates().size() <= 0) {
                    sleep();
                    getUpdates(request);
                    return;
                }

                List<Update> updates = response.updates();
                int lastConfirmedUpdate = listener.process(updates);

                if (lastConfirmedUpdate != CONFIRMED_UPDATES_NONE) {
                    int offset = lastConfirmedUpdate == CONFIRMED_UPDATES_ALL
                            ? lastUpdateId(updates) + 1
                            : lastConfirmedUpdate + 1;
                    request = request.offset(offset);
                }
                getUpdates(request);
            }

            @Override
            public void onFailure(GetUpdates request, IOException e) {
                sleep();
                getUpdates(request);
            }
        });
    }

    private int lastUpdateId(List<Update> updates) {
        return updates.get(updates.size() - 1).updateId();
    }

    private void sleep() {
        if (sleepTimeout <= 0L) return;
        try {
            Thread.sleep(100);
        } catch (InterruptedException ignored) {
        }
    }
}
