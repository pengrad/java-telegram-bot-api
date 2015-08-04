package com.pengrad.telegrambot.model;

/**
 * stas
 * 8/4/15.
 */
public class Message {

    public final Integer message_id;
    public final User from;
    public final Integer date;
    public final User chat;
    public final String text;
    public final PhotoSize[] photo;

    public Message(Integer message_id, User from, Integer date, User chat, String text, PhotoSize[] photo) {
        this.message_id = message_id;
        this.from = from;
        this.date = date;
        this.chat = chat;
        this.text = text;
        this.photo = photo;
    }
}
