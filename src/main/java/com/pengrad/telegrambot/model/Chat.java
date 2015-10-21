package com.pengrad.telegrambot.model;

import com.google.gson.annotations.SerializedName;

/**
 * stas
 * 8/5/15.
 */
public class Chat {

    enum Type {
        @SerializedName("private")PRIVATE,
        @SerializedName("group")GROUP,
        @SerializedName("channel")CHANNEL
    }

    public Long id;
    public Type type;

    //Private
    public String first_name;
    public String last_name;

    //Private and Channel
    public String username;

    //Channel and Group
    public String title;


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
