package com.pengrad.telegrambot.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * Stas Parshin
 * 29 May 2016
 */
public class ChatMember implements Serializable {
    private final static long serialVersionUID = 0L;

    public enum Status {
        creator, administrator, member, restricted, left, kicked;
    }

    private User user;
    private Status status;

    private String custom_title;
    private Boolean is_anonymous;
    private Integer until_date;
    private Boolean can_be_edited;
    private Boolean can_manage_chat;
    private Boolean can_post_messages;
    private Boolean can_edit_messages;
    private Boolean can_delete_messages;
    private Boolean can_manage_voice_chats;
    private Boolean can_restrict_members;
    private Boolean can_promote_members;
    private Boolean can_change_info;
    private Boolean can_invite_users;
    private Boolean can_pin_messages;
    private Boolean is_member;
    private Boolean can_send_messages;
    private Boolean can_send_media_messages;
    private Boolean can_send_polls;
    private Boolean can_send_other_messages;
    private Boolean can_add_web_page_previews;

    public User user() {
        return user;
    }

    public Status status() {
        return status;
    }

    public String customTitle() {
        return custom_title;
    }

    public Boolean isAnonymous() {
        return is_anonymous;
    }

    public Integer untilDate() {
        return until_date;
    }

    public Boolean canBeEdited() {
        return can_be_edited;
    }

    public Boolean canManageChat() {
        return can_manage_chat;
    }

    public Boolean canPostMessages() {
        return can_post_messages;
    }

    public Boolean canEditMessages() {
        return can_edit_messages;
    }

    public Boolean canDeleteMessages() {
        return can_delete_messages;
    }

    public Boolean canManageVoiceChats() {
        return can_manage_voice_chats;
    }

    public Boolean canRestrictMembers() {
        return can_restrict_members;
    }

    public Boolean canPromoteMembers() {
        return can_promote_members;
    }

    public Boolean canChangeInfo() {
        return can_change_info;
    }

    public Boolean canInviteUsers() {
        return can_invite_users;
    }

    public Boolean canPinMessages() {
        return can_pin_messages;
    }

    public Boolean isMember() {
        return is_member;
    }

    public Boolean canSendMessages() {
        return can_send_messages;
    }

    public Boolean canSendMediaMessages() {
        return can_send_media_messages;
    }

    public Boolean canSendPolls() {
        return can_send_polls;
    }

    public Boolean canSendOtherMessages() {
        return can_send_other_messages;
    }

    public Boolean canAddWebPagePreviews() {
        return can_add_web_page_previews;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChatMember that = (ChatMember) o;
        return Objects.equals(user, that.user) &&
                status == that.status &&
                Objects.equals(custom_title, that.custom_title) &&
                Objects.equals(is_anonymous, that.is_anonymous) &&
                Objects.equals(until_date, that.until_date) &&
                Objects.equals(can_be_edited, that.can_be_edited) &&
                Objects.equals(can_manage_chat, that.can_manage_chat) &&
                Objects.equals(can_post_messages, that.can_post_messages) &&
                Objects.equals(can_edit_messages, that.can_edit_messages) &&
                Objects.equals(can_delete_messages, that.can_delete_messages) &&
                Objects.equals(can_manage_voice_chats, that.can_manage_voice_chats) &&
                Objects.equals(can_restrict_members, that.can_restrict_members) &&
                Objects.equals(can_promote_members, that.can_promote_members) &&
                Objects.equals(can_change_info, that.can_change_info) &&
                Objects.equals(can_invite_users, that.can_invite_users) &&
                Objects.equals(can_pin_messages, that.can_pin_messages) &&
                Objects.equals(is_member, that.is_member) &&
                Objects.equals(can_send_messages, that.can_send_messages) &&
                Objects.equals(can_send_media_messages, that.can_send_media_messages) &&
                Objects.equals(can_send_polls, that.can_send_polls) &&
                Objects.equals(can_send_other_messages, that.can_send_other_messages) &&
                Objects.equals(can_add_web_page_previews, that.can_add_web_page_previews);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, status, custom_title, is_anonymous, until_date, can_be_edited, can_manage_chat, can_post_messages, can_edit_messages, can_delete_messages, can_manage_voice_chats, can_restrict_members, can_promote_members, can_change_info, can_invite_users, can_pin_messages, is_member, can_send_messages, can_send_media_messages, can_send_polls, can_send_other_messages, can_add_web_page_previews);
    }

    @Override
    public String toString() {
        return "ChatMember{" +
                "user=" + user +
                ", status=" + status +
                ", custom_title='" + custom_title + '\'' +
                ", is_anonymous=" + is_anonymous +
                ", until_date=" + until_date +
                ", can_be_edited=" + can_be_edited +
                ", can_manage_chat=" + can_manage_chat +
                ", can_post_messages=" + can_post_messages +
                ", can_edit_messages=" + can_edit_messages +
                ", can_delete_messages=" + can_delete_messages +
                ", can_manage_voice_chats=" + can_manage_voice_chats +
                ", can_restrict_members=" + can_restrict_members +
                ", can_promote_members=" + can_promote_members +
                ", can_change_info=" + can_change_info +
                ", can_invite_users=" + can_invite_users +
                ", can_pin_messages=" + can_pin_messages +
                ", is_member=" + is_member +
                ", can_send_messages=" + can_send_messages +
                ", can_send_media_messages=" + can_send_media_messages +
                ", can_send_polls=" + can_send_polls +
                ", can_send_other_messages=" + can_send_other_messages +
                ", can_add_web_page_previews=" + can_add_web_page_previews +
                '}';
    }
}
