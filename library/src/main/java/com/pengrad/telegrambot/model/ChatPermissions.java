package com.pengrad.telegrambot.model;

import java.io.Serializable;

/**
 * Stas Parshin
 * 30 July 2019
 */
public class ChatPermissions implements Serializable {
    private final static long serialVersionUID = 0L;

    private Boolean can_send_messages;
    private Boolean can_send_media_messages;
    private Boolean can_send_polls;
    private Boolean can_send_other_messages;
    private Boolean can_add_web_page_previews;
    private Boolean can_change_info;
    private Boolean can_invite_users;
    private Boolean can_pin_messages;

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

    public Boolean canChangeInfo() {
        return can_change_info;
    }

    public Boolean canInviteUsers() {
        return can_invite_users;
    }

    public Boolean canPinMessages() {
        return can_pin_messages;
    }

    public ChatPermissions canSendMessages(boolean canSendMessages) {
        can_send_messages = canSendMessages;
        return this;
    }

    public ChatPermissions canSendMediaMessages(boolean canSendMediaMessages) {
        can_send_media_messages = canSendMediaMessages;
        return this;
    }

    public ChatPermissions canSendPolls(boolean canSendPolls) {
        can_send_polls = canSendPolls;
        return this;
    }

    public ChatPermissions canSendOtherMessages(boolean canSendOtherMessages) {
        can_send_other_messages = canSendOtherMessages;
        return this;
    }

    public ChatPermissions canAddWebPagePreviews(boolean canAddWebPagePreviews) {
        can_add_web_page_previews = canAddWebPagePreviews;
        return this;
    }

    public ChatPermissions canChangeInfo(boolean canChangeInfo) {
        can_change_info = canChangeInfo;
        return this;
    }

    public ChatPermissions canInviteUsers(boolean canInviteUsers) {
        can_invite_users = canInviteUsers;
        return this;
    }

    public ChatPermissions canPinMessages(boolean canPinMessages) {
        can_pin_messages = canPinMessages;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ChatPermissions that = (ChatPermissions) o;

        if (can_send_messages != null ? !can_send_messages.equals(that.can_send_messages) : that.can_send_messages != null)
            return false;
        if (can_send_media_messages != null ? !can_send_media_messages.equals(that.can_send_media_messages) : that.can_send_media_messages != null)
            return false;
        if (can_send_polls != null ? !can_send_polls.equals(that.can_send_polls) : that.can_send_polls != null) return false;
        if (can_send_other_messages != null ? !can_send_other_messages.equals(that.can_send_other_messages) : that.can_send_other_messages != null)
            return false;
        if (can_add_web_page_previews != null ? !can_add_web_page_previews.equals(that.can_add_web_page_previews) : that.can_add_web_page_previews != null)
            return false;
        if (can_change_info != null ? !can_change_info.equals(that.can_change_info) : that.can_change_info != null)
            return false;
        if (can_invite_users != null ? !can_invite_users.equals(that.can_invite_users) : that.can_invite_users != null)
            return false;
        return can_pin_messages != null ? can_pin_messages.equals(that.can_pin_messages) : that.can_pin_messages == null;
    }

    @Override
    public int hashCode() {
        int result = can_send_messages != null ? can_send_messages.hashCode() : 0;
        result = 31 * result + (can_send_media_messages != null ? can_send_media_messages.hashCode() : 0);
        result = 31 * result + (can_send_polls != null ? can_send_polls.hashCode() : 0);
        result = 31 * result + (can_send_other_messages != null ? can_send_other_messages.hashCode() : 0);
        result = 31 * result + (can_add_web_page_previews != null ? can_add_web_page_previews.hashCode() : 0);
        result = 31 * result + (can_change_info != null ? can_change_info.hashCode() : 0);
        result = 31 * result + (can_invite_users != null ? can_invite_users.hashCode() : 0);
        result = 31 * result + (can_pin_messages != null ? can_pin_messages.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ChatPermissions{" +
                "can_send_messages=" + can_send_messages +
                ", can_send_media_messages=" + can_send_media_messages +
                ", can_send_polls=" + can_send_polls +
                ", can_send_other_messages=" + can_send_other_messages +
                ", can_add_web_page_previews=" + can_add_web_page_previews +
                ", can_change_info=" + can_change_info +
                ", can_invite_users=" + can_invite_users +
                ", can_pin_messages=" + can_pin_messages +
                '}';
    }
}
