package com.pengrad.telegrambot.model;

import java.io.Serializable;

/**
 * stas
 * 8/4/15.
 */
public class User implements Serializable {
    private final static long serialVersionUID = 0L;

    private Integer id;
    private Boolean is_bot;
    private String first_name;
    private String last_name;
    private String username;
    private String language_code;

    public Integer id() {
        return id;
    }

    public Boolean isBot() {
        return is_bot;
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

    public String languageCode() {
        return language_code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        if (is_bot != null ? !is_bot.equals(user.is_bot) : user.is_bot != null) return false;
        if (first_name != null ? !first_name.equals(user.first_name) : user.first_name != null) return false;
        if (last_name != null ? !last_name.equals(user.last_name) : user.last_name != null) return false;
        if (username != null ? !username.equals(user.username) : user.username != null) return false;
        return language_code != null ? language_code.equals(user.language_code) : user.language_code == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", is_bot=" + is_bot +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", username='" + username + '\'' +
                ", language_code='" + language_code + '\'' +
                '}';
    }
}