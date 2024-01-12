package com.pengrad.telegrambot.sample.spark;

import com.pengrad.telegrambot.utility.BotUtils;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.Update;
import spark.Request;
import spark.Response;
import spark.Route;

/**
 * stas
 * 12/2/15.
 */
abstract public class BotHandler implements Route {

    @Override
    public Object handle(Request request, Response response) throws Exception {
        Update update = BotUtils.parseUpdate(request.body());
        Message message = update.message();

        if (isStartMessage(message) && onStart(message)) {
            return "ok";
        } else {
            onWebhookUpdate(update);
        }
        return "ok";
    }

    private boolean isStartMessage(Message message) {
        return message != null && message.text() != null && message.text().startsWith("/start");
    }

    protected boolean onStart(Message message) {
        return false;
    }

    abstract void onWebhookUpdate(Update update);

    abstract String getToken();

    abstract TelegramBot getBot();
}
