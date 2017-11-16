package com.pengrad.telegrambot.sample.spark;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.ext.dispatcher.Dispatcher;
import com.pengrad.telegrambot.ext.dispatcher.UpdateHandler;
import com.pengrad.telegrambot.ext.dispatcher.filters.*;
import com.pengrad.telegrambot.ext.dispatcher.filters.basefilters.Filter;
import com.pengrad.telegrambot.ext.dispatcher.filters.basefilters.MessageTextFilter;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;

/**
 * Created by mattijn on 16-11-2017.
 */
public class DispatcherBot {
    public static void main(String[] args){
        TelegramBot bot = new TelegramBot("token");
        Dispatcher dispatcher = new Dispatcher(bot);
        dispatcher.addHandler(new CommandFilter("help", false), new UpdateHandler() {
            @Override
            public boolean handleUpdate(TelegramBot bot, Update update) {
                bot.execute(new SendMessage(update.message().chat().id(),"help text"));
                return true;
            }
        });
        Filter filter =  new MessageTextFilter(false) {
            @Override
            public boolean filter(String message) {
                return true;
            }
        };

        dispatcher.addHandler(filter, new UpdateHandler() {
            @Override
            public boolean handleUpdate(TelegramBot bot, Update update) {
                bot.execute(new SendMessage(update.message().chat().id(),"a response to text"));
                return false;
            }
        });

        dispatcher.addHandler(new LocationFilter(false), new UpdateHandler() {
            @Override
            public boolean handleUpdate(TelegramBot bot, Update update) {
                bot.execute(new SendMessage(update.message().chat().id(),"a response to a location"));
                return false;
            }
        });
        dispatcher.start();
    }
}
