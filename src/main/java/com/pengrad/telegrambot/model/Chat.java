package com.pengrad.telegrambot.model;

import com.google.gson.annotations.SerializedName;

/**
 * stas
 * 8/5/15.
 */
public class Chat {

    public enum Type {
        @SerializedName("private")Private, group, supergroup, channel
    }

    private Long id;
    private Type type;

    //Private
    private String first_name;
    private String last_name;

    //Private and Channel
    private String username;

    //Channel and Group
    private String title;

    Chat() {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Chat chat = (Chat) o;

        if (id != null ? !id.equals(chat.id) : chat.id != null) return false;
        if (type != chat.type) return false;
        if (first_name != null ? !first_name.equals(chat.first_name) : chat.first_name != null) return false;
        if (last_name != null ? !last_name.equals(chat.last_name) : chat.last_name != null) return false;
        if (username != null ? !username.equals(chat.username) : chat.username != null) return false;
        return title != null ? title.equals(chat.title) : chat.title == null;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
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
