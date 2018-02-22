package com.pengrad.telegrambot.ext.dispatcher;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.ext.dispatcher.filters.basefilters.Filter;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * The dispatcher dispatches Update objects to UpdateHandlers. if the update passes through the filter.
 */
public class Dispatcher extends Thread implements UpdatesListener {
    private final TelegramBot bot;
    private final List<Pair<Filter, UpdateHandler>> handlers;

    public Dispatcher(TelegramBot bot){
        this.bot = bot;
        handlers = new ArrayList<Pair<Filter, UpdateHandler>>();
    }

    @Override
    public void run(){
        bot.setUpdatesListener(this);
    }

    @Override
    public int process(List<Update> updates) {
        int highest_id = 0;
        for (Update update : updates){
            if (update.updateId()>highest_id){highest_id = update.updateId();}
            for (Pair<Filter, UpdateHandler> entry: handlers){
                if (entry.getKey().filter(update)){
                    if (!entry.getValue().handleUpdate(this.bot, update)){
                        break;
                    }
                }
            }
        }
        return highest_id;
    }

    /**
     * add a handler to the dispatcher.
     * @param filter
     * @param handler
     */
    public Pair<Filter,UpdateHandler> addHandler(Filter filter ,UpdateHandler handler){
        Pair<Filter, UpdateHandler> result = new Pair<Filter, UpdateHandler>(filter, handler);
        handlers.add(result);
        return result;
    }

    /**
     * Remove a handler from the dispatcher so it wont be called.
     * @param filter
     * @param handler
     */
    public void removeHandler(Filter filter, UpdateHandler handler){
        removeHandler(new Pair<Filter, UpdateHandler>(filter, handler));
    }

    /**
     * @param pair
     */
    public void removeHandler(Pair<Filter, UpdateHandler> pair){
        handlers.remove(pair);
    }

}
