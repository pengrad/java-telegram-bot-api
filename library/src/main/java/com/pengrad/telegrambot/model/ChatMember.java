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
    private Boolean can_manage_video_chats;
    private Boolean can_restrict_members;
    private Boolean can_promote_members;
    private Boolean can_change_info;
    private Boolean can_invite_users;
    private Boolean can_pin_messages;
    private Boolean can_post_stories;
    private Boolean can_edit_stories;
    private Boolean can_delete_stories;
    private Boolean can_manage_topics;
    private Boolean is_member;
    private Boolean can_send_messages;

    private Boolean can_send_audios;
    private Boolean can_send_documents;
    private Boolean can_send_photos;
    private Boolean can_send_videos;
    private Boolean can_send_video_notes;
    private Boolean can_send_voice_notes;

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
        return is_anonymous != null && is_anonymous;
    }

    public Integer untilDate() {
        return until_date;
    }

    public Boolean canBeEdited() {
        return can_be_edited != null && can_be_edited;
    }

    public Boolean canManageChat() {
        return can_manage_chat != null && can_manage_chat;
    }

    public Boolean canPostMessages() {
        return can_post_messages != null && can_post_messages;
    }

    public Boolean canEditMessages() {
        return can_edit_messages != null && can_edit_messages;
    }

    public Boolean canDeleteMessages() {
        return can_delete_messages != null && can_delete_messages;
    }

    /**
     * @deprecated Use canManageVideoChats() instead
     */
    @Deprecated
    public Boolean canManageVoiceChats() {
        return canManageVideoChats();
    }

    public Boolean canManageVideoChats() {
        return can_manage_video_chats != null && can_manage_video_chats;
    }

    public Boolean canRestrictMembers() {
        return can_restrict_members != null && can_restrict_members;
    }

    public Boolean canPromoteMembers() {
        return can_promote_members != null && can_promote_members;
    }

    public Boolean canChangeInfo() {
        return can_change_info != null && can_change_info;
    }

    public Boolean canInviteUsers() {
        return can_invite_users != null && can_invite_users;
    }

    public Boolean canPinMessages() {
        return can_pin_messages != null && can_pin_messages;
    }

    public Boolean canPostStories() {
        return can_post_stories != null && can_post_stories;
    }

    public Boolean canEditStories() {
        return can_edit_stories != null && can_edit_stories;
    }

    public Boolean canDeleteStories() {
        return can_delete_stories != null && can_delete_stories;
    }

    public Boolean canManageTopics() {
        return can_manage_topics != null && can_manage_topics;
    }

    public Boolean isMember() {
        return is_member != null && is_member;
    }

    public Boolean canSendMessages() {
        return can_send_messages != null && can_send_messages;
    }

    public Boolean canSendAudios() {
        return can_send_audios != null && can_send_audios;
    }

    public Boolean canSendDocuments() {
        return can_send_documents != null && can_send_documents;
    }

    public Boolean canSendPhotos() {
        return can_send_photos != null && can_send_photos;
    }

    public Boolean canSendVideos() {
        return can_send_videos != null && can_send_videos;
    }

    public Boolean canSendVideoNotes() {
        return can_send_video_notes != null && can_send_video_notes;
    }

    public Boolean canSendVoiceNotes() {
        return can_send_voice_notes != null && can_send_voice_notes;
    }

    public Boolean canSendPolls() {
        return can_send_polls != null && can_send_polls;
    }

    public Boolean canSendOtherMessages() {
        return can_send_other_messages != null && can_send_other_messages;
    }

    public Boolean canAddWebPagePreviews() {
        return can_add_web_page_previews != null && can_add_web_page_previews;
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
                Objects.equals(can_manage_video_chats, that.can_manage_video_chats) &&
                Objects.equals(can_restrict_members, that.can_restrict_members) &&
                Objects.equals(can_promote_members, that.can_promote_members) &&
                Objects.equals(can_change_info, that.can_change_info) &&
                Objects.equals(can_invite_users, that.can_invite_users) &&
                Objects.equals(can_pin_messages, that.can_pin_messages) &&
                Objects.equals(can_post_stories, that.can_post_stories) &&
                Objects.equals(can_edit_stories, that.can_edit_stories) &&
                Objects.equals(can_delete_stories, that.can_delete_stories) &&
                Objects.equals(can_manage_topics, that.can_manage_topics) &&
                Objects.equals(is_member, that.is_member) &&
                Objects.equals(can_send_messages, that.can_send_messages) &&
                Objects.equals(can_send_audios, that.can_send_audios) &&
                Objects.equals(can_send_documents, that.can_send_documents) &&
                Objects.equals(can_send_photos, that.can_send_photos) &&
                Objects.equals(can_send_videos, that.can_send_videos) &&
                Objects.equals(can_send_video_notes, that.can_send_video_notes) &&
                Objects.equals(can_send_voice_notes, that.can_send_voice_notes) &&
                Objects.equals(can_send_polls, that.can_send_polls) &&
                Objects.equals(can_send_other_messages, that.can_send_other_messages) &&
                Objects.equals(can_add_web_page_previews, that.can_add_web_page_previews);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user,
                status,
                custom_title,
                is_anonymous,
                until_date,
                can_be_edited,
                can_manage_chat,
                can_post_messages,
                can_edit_messages,
                can_delete_messages,
                can_manage_video_chats,
                can_restrict_members,
                can_promote_members,
                can_change_info,
                can_invite_users,
                can_pin_messages,
                can_post_stories,
                can_edit_stories,
                can_delete_stories,
                can_manage_topics,
                is_member,
                can_send_messages,
                can_send_audios,
                can_send_documents,
                can_send_photos,
                can_send_videos,
                can_send_video_notes,
                can_send_voice_notes,
                can_send_polls,
                can_send_other_messages,
                can_add_web_page_previews);
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
                ", can_manage_video_chats=" + can_manage_video_chats +
                ", can_restrict_members=" + can_restrict_members +
                ", can_promote_members=" + can_promote_members +
                ", can_change_info=" + can_change_info +
                ", can_invite_users=" + can_invite_users +
                ", can_pin_messages=" + can_pin_messages +
                ", can_post_stories=" + can_post_stories +
                ", can_edit_stories=" + can_edit_stories +
                ", can_delete_stories=" + can_delete_stories +
                ", can_manage_topics=" + can_manage_topics +
                ", is_member=" + is_member +
                ", can_send_messages=" + can_send_messages +
                ", can_send_audios=" + can_send_audios +
                ", can_send_documents=" + can_send_documents +
                ", can_send_photos=" + can_send_photos +
                ", can_send_videos=" + can_send_videos +
                ", can_send_video_notes=" + can_send_video_notes +
                ", can_send_voice_notes=" + can_send_voice_notes +
                ", can_send_polls=" + can_send_polls +
                ", can_send_other_messages=" + can_send_other_messages +
                ", can_add_web_page_previews=" + can_add_web_page_previews +
                '}';
    }
}
