package com.pengrad.telegrambot.model.business;

import com.pengrad.telegrambot.model.User;

import java.util.Objects;

public class BusinessConnection {

    private String id;
    private User user;
    private Long user_chat_id;
    private Integer date;
    private Boolean can_reply;
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

    public Boolean canReply() {
        return can_reply;
    }

    public Boolean isEnabled() {
        return is_enabled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BusinessConnection that = (BusinessConnection) o;
        return Objects.equals(id, that.id) && Objects.equals(user, that.user) && Objects.equals(user_chat_id, that.user_chat_id) && Objects.equals(date, that.date) && Objects.equals(can_reply, that.can_reply) && Objects.equals(is_enabled, that.is_enabled);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, user_chat_id, date, can_reply, is_enabled);
    }

    @Override
    public String toString() {
        return "BusinessConnection{" +
                "id='" + id + '\'' +
                ", user=" + user +
                ", user_chat_id=" + user_chat_id +
                ", date=" + date +
                ", can_reply=" + can_reply +
                ", is_enabled=" + is_enabled +
                '}';
    }
}
