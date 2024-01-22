package com.pengrad.telegrambot.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * Mirco Ianese
 * 17 Nov 2021
 */
public class ChatJoinRequest implements Serializable {
    private final static long serialVersionUID = 0L;

    private Chat chat;
    private User from;
    private Long user_chat_id;
    private Integer date;
    private String bio;
    private ChatInviteLink invite_link;

    public Chat chat() {
        return chat;
    }

    public User from() {
        return from;
    }

    public Long userChatId() {
        return user_chat_id;
    }

    public Integer date() {
        return date;
    }

    public String bio() {
        return bio;
    }

    public ChatInviteLink inviteLink() {
        return invite_link;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChatJoinRequest that = (ChatJoinRequest) o;
        return Objects.equals(chat, that.chat) &&
                Objects.equals(from, that.from) &&
                Objects.equals(user_chat_id, that.user_chat_id) &&
                Objects.equals(date, that.date) &&
                Objects.equals(bio, that.bio) &&
                Objects.equals(invite_link, that.invite_link);
    }

    @Override
    public int hashCode() {
        return Objects.hash(chat, from, user_chat_id, date, bio, invite_link);
    }

    @Override
    public String toString() {
        return "ChatJoinRequest{" +
                "chat=" + chat +
                ", from=" + from +
                ", user_chat_id=" + user_chat_id +
                ", date=" + date +
                ", bio=" + bio +
                ", invite_link=" + invite_link +
                '}';
    }
}
