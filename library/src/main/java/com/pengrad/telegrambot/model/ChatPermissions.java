package com.pengrad.telegrambot.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * Stas Parshin
 * 30 July 2019
 */
public class ChatPermissions implements Serializable {
    private final static long serialVersionUID = 0L;

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
    private Boolean can_change_info;
    private Boolean can_invite_users;
    private Boolean can_pin_messages;
    private Boolean can_manage_topics;

    public Boolean canSendMessages() {
        return can_send_messages;
    }

    public Boolean canSendAudios() {
        return can_send_audios;
    }

    public Boolean canSendDocuments() {
        return can_send_documents;
    }

    public Boolean canSendPhotos() {
        return can_send_photos;
    }

    public Boolean canSendVideos() {
        return can_send_videos;
    }

    public Boolean canSendVideoNotes() {
        return can_send_video_notes;
    }

    public Boolean canSendVoiceNotes() {
        return can_send_voice_notes;
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

    public Boolean canManageTopics() {
        return can_manage_topics;
    }

    public ChatPermissions canSendMessages(boolean canSendMessages) {
        can_send_messages = canSendMessages;
        return this;
    }

    public ChatPermissions canSendAudios(boolean canSendAudios) {
        this.can_send_audios = canSendAudios;
        return this;
    }

    public ChatPermissions canSendDocuments(boolean canSendDocuments) {
        this.can_send_documents = canSendDocuments;
        return this;
    }

    public ChatPermissions canSendPhotos(boolean canSendPhotos) {
        this.can_send_photos = canSendPhotos;
        return this;
    }

    public ChatPermissions canSendVideos(boolean canSendVideos) {
        this.can_send_videos = canSendVideos;
        return this;
    }

    public ChatPermissions canSendVideoNotes(boolean canSendVideoNotes) {
        this.can_send_video_notes = canSendVideoNotes;
        return this;
    }

    public ChatPermissions canSendVoiceNotes(boolean canSendVoiceNotes) {
        this.can_send_voice_notes = canSendVoiceNotes;
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

    public ChatPermissions canManageTopics(boolean canManageTopics) {
        this.can_manage_topics = canManageTopics;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ChatPermissions that = (ChatPermissions) o;

        return Objects.equals(can_send_messages, that.can_send_messages) &&
                Objects.equals(can_send_audios, that.can_send_audios) &&
                Objects.equals(can_send_documents, that.can_send_documents) &&
                Objects.equals(can_send_photos, that.can_send_photos) &&
                Objects.equals(can_send_videos, that.can_send_videos) &&
                Objects.equals(can_send_video_notes, that.can_send_video_notes) &&
                Objects.equals(can_send_voice_notes, that.can_send_voice_notes) &&
                Objects.equals(can_send_polls, that.can_send_polls) &&
                Objects.equals(can_send_other_messages, that.can_send_other_messages) &&
                Objects.equals(can_add_web_page_previews, that.can_add_web_page_previews) &&
                Objects.equals(can_change_info, that.can_change_info) &&
                Objects.equals(can_invite_users, that.can_invite_users) &&
                Objects.equals(can_pin_messages, that.can_pin_messages) &&
                Objects.equals(can_manage_topics, that.can_manage_topics);
    }

    @Override
    public int hashCode() {
        return Objects.hash(can_send_messages,
                can_send_audios,
                can_send_documents,
                can_send_photos,
                can_send_videos,
                can_send_video_notes,
                can_send_voice_notes,
                can_send_polls,
                can_send_other_messages,
                can_add_web_page_previews,
                can_change_info,
                can_invite_users,
                can_pin_messages,
                can_manage_topics);
    }

    @Override
    public String toString() {
        return "ChatPermissions{" +
                "can_send_messages=" + can_send_messages +
                ", can_send_audios=" + can_send_audios +
                ", can_send_documents=" + can_send_documents +
                ", can_send_photos=" + can_send_photos +
                ", can_send_videos=" + can_send_videos +
                ", can_send_video_notes=" + can_send_video_notes +
                ", can_send_voice_notes=" + can_send_voice_notes +
                ", can_send_polls=" + can_send_polls +
                ", can_send_other_messages=" + can_send_other_messages +
                ", can_add_web_page_previews=" + can_add_web_page_previews +
                ", can_change_info=" + can_change_info +
                ", can_invite_users=" + can_invite_users +
                ", can_pin_messages=" + can_pin_messages +
                ", can_manage_topics=" + can_manage_topics +
                '}';
    }
}
