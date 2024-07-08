package com.pengrad.telegrambot.model;

import com.google.gson.annotations.SerializedName;
import com.pengrad.telegrambot.model.business.BusinessIntro;
import com.pengrad.telegrambot.model.business.BusinessLocation;
import com.pengrad.telegrambot.model.business.BusinessOpeningHours;
import com.pengrad.telegrambot.model.reaction.ReactionType;


import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;


public class ChatFullInfo implements Serializable {
    private final static long serialVersionUID = 0L;

    public enum Type {
        @SerializedName("private") Private, group, supergroup, channel
    }

    private Long id;
    private Type type;

    //Channel and Group
    private String title;

    //Private and Channel
    private String username;

    //Private
    private String first_name;
    private String last_name;

    private Boolean is_forum;
    private ChatPhoto photo;
    private String[] active_usernames;
    private Birthdate birthdate;
    private BusinessIntro business_intro;
    private BusinessLocation business_location;
    private BusinessOpeningHours business_opening_hours;
    private Chat personal_chat;
    private ReactionType[] available_reactions;
    private Integer accent_color_id;
    private Integer max_reaction_count;
    private String background_custom_emoji_id;
    private Integer profile_accent_color_id;
    private String profile_background_custom_emoji_id;
    private String emoji_status_custom_emoji_id;
    private Integer emoji_status_expiration_date;
    private String bio;
    private Boolean has_private_forwards;
    private Boolean has_restricted_voice_and_video_messages;
    private Boolean has_hidden_members;
    private Boolean has_aggressive_anti_spam_enabled;
    private Boolean join_to_send_messages;
    private Boolean join_by_request;
    private String description;
    private String invite_link;
    private Message pinned_message;
    private ChatPermissions permissions;
    private Boolean can_send_paid_media;
    private Integer slow_mode_delay;
    private Integer unrestrict_boost_count;
    private Integer message_auto_delete_time;
    private Boolean has_protected_content;
    private Boolean has_visible_history;
    private String sticker_set_name;
    private Boolean can_set_sticker_set;
    private String custom_emoji_sticker_set_name;
    private Long linked_chat_id;
    private ChatLocation location;

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

    public Boolean isForum() {
        return is_forum != null && is_forum;
    }

    public String title() {
        return title;
    }

    public ChatPhoto photo() {
        return photo;
    }

    /**
     * @deprecated Use activeUsernames() instead
     */
    @Deprecated
    public String[] getActiveUsernames() {
        return active_usernames;
    }

    public String[] activeUsernames() {
        return active_usernames;
    }

    public Birthdate birthdate() {
        return birthdate;
    }

    public BusinessIntro businessIntro() {
        return business_intro;
    }

    public BusinessLocation businessLocation() {
        return business_location;
    }

    public BusinessOpeningHours businessOpeningHours() {
        return business_opening_hours;
    }

    public Chat personalChat() {
        return personal_chat;
    }

    public ReactionType[] availableReactions() {
        return available_reactions;
    }

    public Integer accentColorId() {
        return accent_color_id;
    }

    public Integer maxReactionCount() {
        return max_reaction_count;
    }

    public String backgroundCustomEmojiId() {
        return background_custom_emoji_id;
    }

    public Integer profileAccentColorId() {
        return profile_accent_color_id;
    }

    public String profileBackgroundCustomEmojiId() {
        return profile_background_custom_emoji_id;
    }

    /**
     * @deprecated Use emojiStatusCustomEmojiId() instead
     */
    @Deprecated
    public String getEmojiStatusCustomEmojiId() {
        return emoji_status_custom_emoji_id;
    }

    public String emojiStatusCustomEmojiId() {
        return emoji_status_custom_emoji_id;
    }

    public Integer emojiStatusExpirationDate() {
        return emoji_status_expiration_date;
    }

    public String bio() {
        return bio;
    }

    public Boolean hasPrivateForwards() {
        return has_private_forwards != null && has_private_forwards;
    }

    public Boolean hasRestrictedVoiceAndVideoMessages() {
        return has_restricted_voice_and_video_messages != null && has_restricted_voice_and_video_messages;
    }

    public Boolean hasHiddenMembers() {
        return has_hidden_members != null && has_hidden_members;
    }

    public Boolean hasAggressiveAntiSpamEnabled() {
        return has_aggressive_anti_spam_enabled != null && has_aggressive_anti_spam_enabled;
    }

    public Boolean joinToSendMessages() {
        return join_to_send_messages != null && join_to_send_messages;
    }

    public Boolean joinByRequest() {
        return join_by_request != null && join_by_request;
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
    public Boolean canSendPaidMedia() {
        return can_send_paid_media;
    }

    public Integer slowModeDelay() {
        return slow_mode_delay;
    }

    public Integer unrestrictBoostCount() {
        return unrestrict_boost_count;
    }

    public Integer messageAutoDeleteTime() {
        return message_auto_delete_time;
    }

    public Boolean hasProtectedContent() {
        return has_protected_content != null && has_protected_content;
    }

    public Boolean hasVisibleHistory() {
        return has_visible_history != null && has_visible_history;
    }

    public String stickerSetName() {
        return sticker_set_name;
    }

    public Boolean canSetStickerSet() {
        return can_set_sticker_set != null && can_set_sticker_set;
    }

    public String customEmojiStickerSetName() {
        return custom_emoji_sticker_set_name;
    }

    public Long linkedChatId() {
        return linked_chat_id;
    }

    public ChatLocation location() {
        return location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChatFullInfo chat = (ChatFullInfo) o;
        return Objects.equals(id, chat.id) &&
                type == chat.type &&
                Objects.equals(first_name, chat.first_name) &&
                Objects.equals(last_name, chat.last_name) &&
                Objects.equals(is_forum, chat.is_forum) &&
                Objects.equals(username, chat.username) &&
                Objects.equals(title, chat.title) &&
                Objects.equals(photo, chat.photo) &&
                Arrays.equals(active_usernames, chat.active_usernames) &&
                Objects.equals(birthdate, chat.birthdate) &&
                Objects.equals(business_intro, chat.business_intro) &&
                Objects.equals(business_location, chat.business_location) &&
                Objects.equals(business_opening_hours, chat.business_opening_hours) &&
                Objects.equals(personal_chat, chat.personal_chat) &&
                Arrays.equals(available_reactions, chat.available_reactions) &&
                Objects.equals(accent_color_id, chat.accent_color_id) &&
                Objects.equals(max_reaction_count, chat.max_reaction_count) &&
                Objects.equals(background_custom_emoji_id, chat.background_custom_emoji_id) &&
                Objects.equals(profile_accent_color_id, chat.profile_accent_color_id) &&
                Objects.equals(profile_background_custom_emoji_id, chat.profile_background_custom_emoji_id) &&
                Objects.equals(emoji_status_custom_emoji_id, chat.emoji_status_custom_emoji_id) &&
                Objects.equals(emoji_status_expiration_date, chat.emoji_status_expiration_date) &&
                Objects.equals(bio, chat.bio) &&
                Objects.equals(has_private_forwards, chat.has_private_forwards) &&
                Objects.equals(has_restricted_voice_and_video_messages, chat.has_restricted_voice_and_video_messages) &&
                Objects.equals(has_hidden_members, chat.has_hidden_members) &&
                Objects.equals(has_aggressive_anti_spam_enabled, chat.has_aggressive_anti_spam_enabled) &&
                Objects.equals(join_to_send_messages, chat.join_to_send_messages) &&
                Objects.equals(join_by_request, chat.join_by_request) &&
                Objects.equals(description, chat.description) &&
                Objects.equals(invite_link, chat.invite_link) &&
                Objects.equals(pinned_message, chat.pinned_message) &&
                Objects.equals(permissions, chat.permissions) &&
                Objects.equals(can_send_paid_media, chat.can_send_paid_media) &&
                Objects.equals(slow_mode_delay, chat.slow_mode_delay) &&
                Objects.equals(unrestrict_boost_count, chat.unrestrict_boost_count) &&
                Objects.equals(message_auto_delete_time, chat.message_auto_delete_time) &&
                Objects.equals(has_protected_content, chat.has_protected_content) &&
                Objects.equals(has_visible_history, chat.has_visible_history) &&
                Objects.equals(sticker_set_name, chat.sticker_set_name) &&
                Objects.equals(can_set_sticker_set, chat.can_set_sticker_set) &&
                Objects.equals(custom_emoji_sticker_set_name, chat.custom_emoji_sticker_set_name) &&
                Objects.equals(linked_chat_id, chat.linked_chat_id) &&
                Objects.equals(location, chat.location);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "ChatFullInfo{" +
                "id=" + id +
                ", type=" + type +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", is_forum=" + is_forum +
                ", username='" + username + '\'' +
                ", title='" + title + '\'' +
                ", photo=" + photo +
                ", active_usernames=" + Arrays.toString(active_usernames) +
                ", birthdate=" + birthdate +
                ", business_intro=" + business_intro +
                ", business_location=" + business_location +
                ", business_opening_hours=" + business_opening_hours +
                ", personal_chat=" + personal_chat +
                ", available_reactions=" + Arrays.toString(available_reactions) +
                ", accent_color_id=" + accent_color_id +
                ", max_reaction_count=" + max_reaction_count +
                ", background_custom_emoji_id='" + background_custom_emoji_id + '\'' +
                ", profile_accent_color_id=" + profile_accent_color_id +
                ", profile_background_custom_emoji_id='" + profile_background_custom_emoji_id + '\'' +
                ", emoji_status_custom_emoji_id='" + emoji_status_custom_emoji_id + '\'' +
                ", emoji_status_expiration_date='" + emoji_status_expiration_date + '\'' +
                ", bio='" + bio + '\'' +
                ", has_private_forwards=" + has_private_forwards +
                ", has_restricted_voice_and_video_messages=" + has_restricted_voice_and_video_messages +
                ", has_hidden_members=" + has_hidden_members +
                ", has_aggressive_anti_spam_enabled=" + has_aggressive_anti_spam_enabled +
                ", join_to_send_messages=" + join_to_send_messages +
                ", join_by_request=" + join_by_request +
                ", description='" + description + '\'' +
                ", invite_link='" + invite_link + '\'' +
                ", pinned_message=" + pinned_message +
                ", permissions=" + permissions +
                ", can_send_paid_media=" + can_send_paid_media +
                ", slow_mode_delay=" + slow_mode_delay +
                ", unrestrict_boost_count=" + unrestrict_boost_count +
                ", message_auto_delete_time=" + message_auto_delete_time +
                ", has_protected_content=" + has_protected_content +
                ", has_visible_history=" + has_visible_history +
                ", sticker_set_name='" + sticker_set_name + '\'' +
                ", can_set_sticker_set=" + can_set_sticker_set +
                ", custom_emoji_sticker_set_name=" + custom_emoji_sticker_set_name +
                ", linked_chat_id=" + linked_chat_id +
                ", location=" + location +
                '}';
    }
}
