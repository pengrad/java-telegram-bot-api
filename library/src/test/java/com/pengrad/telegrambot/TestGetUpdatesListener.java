package com.pengrad.telegrambot;

import com.pengrad.telegrambot.model.Update;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

/**
 * Stas Parshin
 * 29 September 2016
 */
public class TestGetUpdatesListener {

    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("local.properties"));
        final TelegramBot bot = new TelegramBot(properties.getProperty("TEST_TOKEN"));

        bot.setUpdatesListener(new UpdatesListener() {

            int updatesCount = 5;

            @Override
            public int process(List<Update> updates) {
                System.out.println(updates);
                if (--updatesCount <= 0) bot.removeGetUpdatesListener();
                return UpdatesListener.CONFIRMED_UPDATES_ALL;
            }
        });

        while (true) {
            try {
                Thread.currentThread().sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
