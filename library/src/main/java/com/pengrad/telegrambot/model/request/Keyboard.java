package com.pengrad.telegrambot.model.request;

import com.google.gson.Gson;

import java.io.Serializable;

/**
 * stas
 * 8/11/15
 */
public abstract class Keyboard implements Serializable {
    private final static long serialVersionUID = 0L;

    // todo remove gson
    private static Gson gson = new Gson();

    @Override
    public final String toString() {
        return gson.toJson(this);
    }

}
