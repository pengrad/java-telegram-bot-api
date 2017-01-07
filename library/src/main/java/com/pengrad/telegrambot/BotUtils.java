package com.pengrad.telegrambot;

import com.google.gson.Gson;
import com.pengrad.telegrambot.model.Update;

import java.io.Reader;

/**
 * stas
 * 11/1/15.
 */
public class BotUtils {

    private static Gson gson = new Gson();

    public static Update parseUpdate(String update) {
        return gson.fromJson(update, Update.class);
    }

    public static Update parseUpdate(Reader reader) {
        return gson.fromJson(reader, Update.class);
    }

}
