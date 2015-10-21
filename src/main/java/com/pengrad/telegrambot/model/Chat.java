package com.pengrad.telegrambot.model;

import com.google.gson.annotations.SerializedName;

/**
 * stas
 * 8/5/15.
 */
public class Chat {

    enum Type {
        @SerializedName("private")Private, group, channel
    }

    private final Long id;
    private final Type type;

    //Private
    private final String first_name;
    private final String last_name;

    //Private and Channel
    private final String username;

    //Channel and Group
    private final String title;

    public Chat(Long id, Type type, String first_name, String last_name, String username, String title) {
        this.id = id;
        this.type = type;
        this.first_name = first_name;
        this.last_name = last_name;
        this.username = username;
        this.title = title;
    }

    public Long id() {
        return id;
    }

    public Type type() {
        return type;
    }

    public String firstName() {
        return first_name;
    }

    public String lastName() {
        return last_name;
    }

    public String username() {
        return username;
    }

    public String title() {
        return title;
    }

    @Override
    public String toString() {
        return "Chat{" +
                "id=" + id +
                ", type=" + type +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", username='" + username + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
