package com.pengrad.telegrambot.model;

/**
 * stas
 * 8/4/15.
 */
public class User {
    public final Integer id;
    public final String first_name;
    public final String last_name;
    public final String username;

    public User(Integer id, String first_name, String last_name, String username) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.username = username;
    }
}