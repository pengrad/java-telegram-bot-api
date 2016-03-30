package com.pengrad.telegrambot;

import com.pengrad.telegrambot.model.Chat;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.User;
import com.pengrad.telegrambot.response.GetUpdatesResponse;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

/**
 * stas
 * 3/31/16.
 */
public class TestLoopGetUpdates {

    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("local.properties"));
        TelegramBot bot = TelegramBotAdapter.build(properties.getProperty("TEST_TOKEN"));

        GetUpdatesResponse updatesResponse;
        int j = 0;
        while (true) {
            try {
                updatesResponse = bot.getUpdates(j, 100, 20);
                List<Update> updates = updatesResponse.updates();
                for (int z = 0; z < updates.size(); z++) {
                    j = updates.get(z).updateId() + 1;
                    Message message = updates.get(z).message();
                    //
                    Chat chat = message.chat();
                    User user = message.from();
                    //String mes=message.text();

                    // Base64.getEncoder().encodeToString(s.getBytes(StandardCharsets.UTF_8));
                    if (message.text() != null) {
                        System.out.println("New message: " + message.text() + " id: " + message.messageId() + " from " + chat);
                    }

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
