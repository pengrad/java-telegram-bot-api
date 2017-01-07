package com.pengrad.telegrambot.model;

/**
 * Stas Parshin
 * 29 May 2016
 */
public class ChatMember {

    public enum Status {
        creator, administrator, member, left, kicked;
    }

    private User user;
    private Status status;

    public User user() {
        return user;
    }

    public Status status() {
        return status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ChatMember that = (ChatMember) o;

        if (user != null ? !user.equals(that.user) : that.user != null) return false;
        return status == that.status;

    }

    @Override
    public int hashCode() {
        int result = user != null ? user.hashCode() : 0;
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ChatMember{" +
                "user=" + user +
                ", status=" + status +
                '}';
    }
}
