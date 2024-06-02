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
    private Boolean via_chat_folder_invite_link;
    private Boolean via_join_request;

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

    public Boolean viaChatFolderInviteLink() {
        return via_chat_folder_invite_link;
    }

    public Boolean viaJoinRequest() {
        return via_join_request;
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
                Objects.equals(invite_link, that.invite_link) &&
                Objects.equals(via_chat_folder_invite_link, that.via_chat_folder_invite_link) &&
                Objects.equals(via_join_request, that.via_join_request);
    }

    @Override
    public int hashCode() {
        return Objects.hash(chat, from, date, old_chat_member, new_chat_member, invite_link, via_chat_folder_invite_link, via_join_request);
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
                ", via_chat_folder_invite_link=" + via_chat_folder_invite_link +
                ", via_join_request=" + via_join_request +
                '}';
    }
}

