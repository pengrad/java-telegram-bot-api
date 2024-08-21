package com.pengrad.telegrambot.model.shared;

import com.pengrad.telegrambot.model.PhotoSize;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

public class SharedUser implements Serializable {

    private final static long serialVersionUID = 0L;

    private Long user_id;
    private String first_name;
    private String last_name;
    private String username;
    private PhotoSize[] photo;

    public Long userId() {
        return user_id;
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

    public PhotoSize[] photo() {
        return photo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SharedUser that = (SharedUser) o;
        return Objects.equals(user_id, that.user_id) && Objects.equals(first_name, that.first_name) && Objects.equals(last_name, that.last_name) && Objects.equals(username, that.username) && Objects.deepEquals(photo, that.photo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user_id, first_name, last_name, username, Arrays.hashCode(photo));
    }

    @Override
    public String toString() {
        return "SharedUser{" +
                "user_id=" + user_id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", username='" + username + '\'' +
                ", photo=" + Arrays.toString(photo) +
                '}';
    }
}
