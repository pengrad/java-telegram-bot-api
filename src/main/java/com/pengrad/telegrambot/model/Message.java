package com.pengrad.telegrambot.model;

/**
 * stas
 * 8/4/15.
 */
public class Message {

    public Integer message_id;
    public User from;
    public Integer date;
    public UserOrGroupChat chat;
    public User forward_from;
    public Integer forward_date;
    public Message reply_to_message;
    public String text;
    public Audio audio;
    public Document document;
    public PhotoSize[] photo;
    public Sticker sticker;
    public Video video;
    public Voice voice;
    public String caption;
    public Contact contact;
    public Location location;
    public User new_chat_participant;
    public User left_chat_participant;
    public String new_chat_title;
    public PhotoSize[] new_chat_photo;
    public Boolean delete_chat_photo;
    public Boolean group_chat_created;
}
