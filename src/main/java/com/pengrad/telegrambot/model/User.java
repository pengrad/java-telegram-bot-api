package com.pengrad.telegrambot.model;

/**
 * stas
 * 8/4/15.
 */
public class User {

    private Integer id;
    private String first_name;
    private String last_name;
    private String username;

    User() {
    }

    public Integer id() {
        return id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        if (first_name != null ? !first_name.equals(user.first_name) : user.first_name != null) return false;
        if (last_name != null ? !last_name.equals(user.last_name) : user.last_name != null) return false;
        if (username != null ? !username.equals(user.username) : user.username != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}