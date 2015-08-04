package com.pengrad.telegrambot.model;

/**
 * stas
 * 8/5/15.
 */
public class UserOrGroupChat {

    public Integer id;

    //User
    public String first_name;
    public String last_name;
    public String username;

    //Group
    public String title;

    public boolean isUser() {
        return first_name != null;
    }
}
