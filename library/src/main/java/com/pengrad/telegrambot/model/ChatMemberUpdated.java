package com.pengrad.telegrambot.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * Stas Parshin
 * 10 March 2021
 */
public class ChatMemberUpdated implements Serializable {
    private final static long serialVersionUID = 0L;

    private Chat chat;
    private User from;
    private Integer date;
    private ChatMember old_chat_member;
    private ChatMember new_chat_member;
    private ChatInviteLink invite_link;

    public Chat chat() {
        return chat;
    }

    public User from() {
        return from;
    }

    public Integer date() {
        return date;
    }

    public ChatMember oldChatMember() {
        return old_chat_member;
    }

    public ChatMember newChatMember() {
        return new_chat_member;
    }

    public ChatInviteLink inviteLink() {
        return invite_link;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChatMemberUpdated that = (ChatMemberUpdated) o;
        return Objects.equals(chat, that.chat) &&
                Objects.equals(from, that.from) &&
                Objects.equals(date, that.date) &&
                Objects.equals(old_chat_member, that.old_chat_member) &&
                Objects.equals(new_chat_member, that.new_chat_member) &&
                Objects.equals(invite_link, that.invite_link);
    }

    @Override
    public int hashCode() {
        return Objects.hash(chat, from, date, old_chat_member, new_chat_member, invite_link);
    }

    @Override
    public String toString() {
        return "ChatMemberUpdated{" +
                "chat=" + chat +
                ", from=" + from +
                ", date=" + date +
                ", old_chat_member=" + old_chat_member +
                ", new_chat_member=" + new_chat_member +
                ", invite_link=" + invite_link +
                '}';
    }
}

