package com.pengrad.telegrambot;

import com.pengrad.telegrambot.model.Chat;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.User;
import com.pengrad.telegrambot.request.GetUpdates;
import com.pengrad.telegrambot.request.SetWebhook;
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

    // TODO write proper tests
    // 1. Exception in UpdateListener will fail and stop update handler
    // 2. Exception in lib will be logged and updates continue
    // 3. Bad response from API will be logged and updates continue

    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        properties.load(new FileInputStream("library/local.properties"));
        TelegramBot bot = new TelegramBot.Builder(properties.getProperty("TEST_TOKEN"))
//                .okHttpClient(new OkHttpClient.Builder().readTimeout(Duration.ofSeconds(1)).build())
                .updateListenerSleep(1000)
                .build();

//        bot.execute(new SetWebhook().url("https://google.com"));
        bot.execute(new SetWebhook());

        bot.setUpdatesListener(updates -> {
            System.out.println("update");
//            updates.get(0).callbackQuery().chatInstance();
            return UpdatesListener.CONFIRMED_UPDATES_ALL;
        }, new GetUpdates().timeout(1));
    }

    public static void main2(String[] args) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("local.properties"));
        TelegramBot bot = TelegramBotAdapter.build(properties.getProperty("TEST_TOKEN"));

        GetUpdatesResponse updatesResponse;
        int j = 0;
        while (true) {
            try {
                updatesResponse = bot.execute(new GetUpdates().offset(j).limit(100).timeout(20));
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
