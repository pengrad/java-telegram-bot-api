package com.pengrad.telegrambot.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Objects;

/**
 * stas
 * 8/5/15.
 */
public class Chat implements Serializable {
    private final static long serialVersionUID = 0L;

    public enum Type {
        @SerializedName("private") Private, group, supergroup, channel
    }

    private Long id;
    private Type type;

    //Channel and Group
    private String title;

    //Private and Channel
    private String username;

    //Private
    private String first_name;
    private String last_name;

    private Boolean is_forum;

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

    public Boolean isForum() {
        return is_forum != null && is_forum;
    }

    public String title() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chat chat = (Chat) o;
        return Objects.equals(id, chat.id) &&
                type == chat.type &&
                Objects.equals(first_name, chat.first_name) &&
                Objects.equals(last_name, chat.last_name) &&
                Objects.equals(is_forum, chat.is_forum) &&
                Objects.equals(username, chat.username) &&
                Objects.equals(title, chat.title);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Chat{" +
                "id=" + id +
                ", type=" + type +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", is_forum=" + is_forum +
                ", username='" + username + '\'' +
                ", title='" + title + '\'' +                
                '}';
    }
}
