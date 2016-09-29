package com.pengrad.telegrambot;

import com.pengrad.telegrambot.model.Update;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

/**
 * Stas Parshin
 * 29 September 2016
 */
public class TestGetUpdatesListener {

    TelegramBot bot;

    public TestGetUpdatesListener() throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("local.properties"));
        bot = TelegramBotAdapter.build(properties.getProperty("TEST_TOKEN"));
    }

    @Test
    public void getUpdatesListener() {
        bot.setGetUpdatetsListener(new GetUpdatesListener() {

            int updatesCount = 5;

            @Override
            public int process(List<Update> updates) {
                System.out.println(updates);
                if (--updatesCount <= 0) bot.removeGetUpdatesListener();
                return GetUpdatesListener.CONFIRMED_UPDATES_ALL;
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
