package com.pengrad.telegrambot.model;

import java.io.Serializable;

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
    private Integer until_date;
    private Boolean can_be_edited;
    private Boolean can_post_messages;
    private Boolean can_edit_messages;
    private Boolean can_delete_messages;
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

    public Integer untilDate() {
        return until_date;
    }

    public Boolean canBeEdited() {
        return can_be_edited;
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

        if (user != null ? !user.equals(that.user) : that.user != null) return false;
        if (status != that.status) return false;
        if (custom_title != null ? !custom_title.equals(that.custom_title) : that.custom_title != null) return false;
        if (until_date != null ? !until_date.equals(that.until_date) : that.until_date != null) return false;
        if (can_be_edited != null ? !can_be_edited.equals(that.can_be_edited) : that.can_be_edited != null) return false;
        if (can_post_messages != null ? !can_post_messages.equals(that.can_post_messages) : that.can_post_messages != null)
            return false;
        if (can_edit_messages != null ? !can_edit_messages.equals(that.can_edit_messages) : that.can_edit_messages != null)
            return false;
        if (can_delete_messages != null ? !can_delete_messages.equals(that.can_delete_messages) : that.can_delete_messages != null)
            return false;
        if (can_restrict_members != null ? !can_restrict_members.equals(that.can_restrict_members) : that.can_restrict_members != null)
            return false;
        if (can_promote_members != null ? !can_promote_members.equals(that.can_promote_members) : that.can_promote_members != null)
            return false;
        if (can_change_info != null ? !can_change_info.equals(that.can_change_info) : that.can_change_info != null)
            return false;
        if (can_invite_users != null ? !can_invite_users.equals(that.can_invite_users) : that.can_invite_users != null)
            return false;
        if (can_pin_messages != null ? !can_pin_messages.equals(that.can_pin_messages) : that.can_pin_messages != null)
            return false;
        if (is_member != null ? !is_member.equals(that.is_member) : that.is_member != null) return false;
        if (can_send_messages != null ? !can_send_messages.equals(that.can_send_messages) : that.can_send_messages != null)
            return false;
        if (can_send_media_messages != null ? !can_send_media_messages.equals(that.can_send_media_messages) : that.can_send_media_messages != null)
            return false;
        if (can_send_polls != null ? !can_send_polls.equals(that.can_send_polls) : that.can_send_polls != null) return false;
        if (can_send_other_messages != null ? !can_send_other_messages.equals(that.can_send_other_messages) : that.can_send_other_messages != null)
            return false;
        return can_add_web_page_previews != null ? can_add_web_page_previews.equals(that.can_add_web_page_previews) : that.can_add_web_page_previews == null;
    }

    @Override
    public int hashCode() {
        int result = user != null ? user.hashCode() : 0;
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (custom_title != null ? custom_title.hashCode() : 0);
        result = 31 * result + (until_date != null ? until_date.hashCode() : 0);
        result = 31 * result + (can_be_edited != null ? can_be_edited.hashCode() : 0);
        result = 31 * result + (can_post_messages != null ? can_post_messages.hashCode() : 0);
        result = 31 * result + (can_edit_messages != null ? can_edit_messages.hashCode() : 0);
        result = 31 * result + (can_delete_messages != null ? can_delete_messages.hashCode() : 0);
        result = 31 * result + (can_restrict_members != null ? can_restrict_members.hashCode() : 0);
        result = 31 * result + (can_promote_members != null ? can_promote_members.hashCode() : 0);
        result = 31 * result + (can_change_info != null ? can_change_info.hashCode() : 0);
        result = 31 * result + (can_invite_users != null ? can_invite_users.hashCode() : 0);
        result = 31 * result + (can_pin_messages != null ? can_pin_messages.hashCode() : 0);
        result = 31 * result + (is_member != null ? is_member.hashCode() : 0);
        result = 31 * result + (can_send_messages != null ? can_send_messages.hashCode() : 0);
        result = 31 * result + (can_send_media_messages != null ? can_send_media_messages.hashCode() : 0);
        result = 31 * result + (can_send_polls != null ? can_send_polls.hashCode() : 0);
        result = 31 * result + (can_send_other_messages != null ? can_send_other_messages.hashCode() : 0);
        result = 31 * result + (can_add_web_page_previews != null ? can_add_web_page_previews.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ChatMember{" +
                "user=" + user +
                ", status=" + status +
                ", custom_title='" + custom_title + '\'' +
                ", until_date=" + until_date +
                ", can_be_edited=" + can_be_edited +
                ", can_post_messages=" + can_post_messages +
                ", can_edit_messages=" + can_edit_messages +
                ", can_delete_messages=" + can_delete_messages +
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
