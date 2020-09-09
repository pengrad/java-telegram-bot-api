package com.pengrad.telegrambot.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Objects;

/**
 * stas
 * 8/5/15.
 */
public class Chat implements Serializable {
    private final static long serialVersionUID = 0L;

    public enum Type {
        @SerializedName("private") Private, group, supergroup, channel
    }

    private Long id;
    private Type type;

    //Private
    private String first_name;
    private String last_name;

    //Private and Channel
    private String username;

    //Channel and Group
    private String title;

    // TODO delete this field
    private Boolean all_members_are_administrators;

    private ChatPhoto photo;
    private String description;
    private String invite_link;
    private Message pinned_message;
    private ChatPermissions permissions;
    private Integer slow_mode_delay;
    private String sticker_set_name;
    private Boolean can_set_sticker_set;

    public Long id() {
        return id;
    }

    public Type type() {
        return type;
    }

    public String firstName() {
        return first_name;
    }

    public String lastName() {
        return last_name;
    }

    public String username() {
        return username;
    }

    public String title() {
        return title;
    }

    public Boolean allMembersAreAdministrators() {
        return all_members_are_administrators;
    }

    public ChatPhoto photo() {
        return photo;
    }

    public String description() {
        return description;
    }

    public String inviteLink() {
        return invite_link;
    }

    public Message pinnedMessage() {
        return pinned_message;
    }

    public ChatPermissions permissions() {
        return permissions;
    }

    public Integer slowModeDelay() {
        return slow_mode_delay;
    }

    public String stickerSetName() {
        return sticker_set_name;
    }

    public Boolean canSetStickerSet() {
        return can_set_sticker_set;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Chat chat = (Chat) o;

        if (!Objects.equals(id, chat.id)) return false;
        if (type != chat.type) return false;
        if (!Objects.equals(first_name, chat.first_name)) return false;
        if (!Objects.equals(last_name, chat.last_name)) return false;
        if (!Objects.equals(username, chat.username)) return false;
        if (!Objects.equals(title, chat.title)) return false;
        if (!Objects.equals(all_members_are_administrators, chat.all_members_are_administrators))
            return false;
        if (!Objects.equals(photo, chat.photo)) return false;
        if (!Objects.equals(description, chat.description)) return false;
        if (!Objects.equals(invite_link, chat.invite_link)) return false;
        if (!Objects.equals(pinned_message, chat.pinned_message)) return false;
        if (!Objects.equals(permissions, chat.permissions)) return false;
        if (!Objects.equals(slow_mode_delay, chat.slow_mode_delay))
            return false;
        if (!Objects.equals(sticker_set_name, chat.sticker_set_name))
            return false;
        return Objects.equals(can_set_sticker_set, chat.can_set_sticker_set);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Chat{" +
                "id=" + id +
                ", type=" + type +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", username='" + username + '\'' +
                ", title='" + title + '\'' +
                ", all_members_are_administrators=" + all_members_are_administrators +
                ", photo=" + photo +
                ", description='" + description + '\'' +
                ", invite_link='" + invite_link + '\'' +
                ", pinned_message=" + pinned_message +
                ", permissions=" + permissions +
                ", slow_mode_delay=" + slow_mode_delay +
                ", sticker_set_name='" + sticker_set_name + '\'' +
                ", can_set_sticker_set=" + can_set_sticker_set +
                '}';
    }
}
