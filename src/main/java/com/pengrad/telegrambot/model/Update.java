package com.pengrad.telegrambot.model;

/**
 * stas
 * 8/4/15.
 */
public class Update {

    public final Integer update_id;
    public final Message message;

    public Update(Integer update_id, Message message) {
        this.update_id = update_id;
        this.message = message;
    }
}
