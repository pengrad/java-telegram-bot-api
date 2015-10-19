package com.pengrad.telegrambot.model;

import com.google.gson.Gson;

/**
 * stas
 * 8/11/15
 */
public abstract class Keyboard {

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
