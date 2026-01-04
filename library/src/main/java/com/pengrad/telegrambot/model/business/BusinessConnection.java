package com.pengrad.telegrambot.model.business;

import com.pengrad.telegrambot.model.User;

import java.util.Objects;

public class BusinessConnection {

    private String id;
    private User user;
    private Long user_chat_id;
    private Integer date;
    private BusinessBotRights rights;
    private Boolean is_enabled;

    public String id() {
        return id;
    }

    public User user() {
        return user;
    }

    public Long userChatId() {
        return user_chat_id;
    }

    public Integer date() {
        return date;
    }

    public BusinessBotRights rights() {
        return rights;
    }

    public Boolean isEnabled() {
        return is_enabled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BusinessConnection that = (BusinessConnection) o;
        return Objects.equals(id, that.id) && Objects.equals(user, that.user) && Objects.equals(user_chat_id, that.user_chat_id) && Objects.equals(date, that.date) && Objects.equals(rights, that.rights) && Objects.equals(is_enabled, that.is_enabled);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, user_chat_id, date, rights, is_enabled);
    }

    @Override
    public String toString() {
        return "BusinessConnection{" +
                "id='" + id + '\'' +
                ", user=" + user +
                ", user_chat_id=" + user_chat_id +
                ", date=" + date +
                ", rights=" + rights +
                ", is_enabled=" + is_enabled +
                '}';
    }
}
