package com.pengrad.telegrambot.model;

import com.pengrad.telegrambot.model.giveaway.Giveaway;
import com.pengrad.telegrambot.model.giveaway.GiveawayCompleted;
import com.pengrad.telegrambot.model.giveaway.GiveawayCreated;
import com.pengrad.telegrambot.model.giveaway.GiveawayWinners;
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;
import com.pengrad.telegrambot.passport.PassportData;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

/**
 * stas
 * 8/4/15.
 */
public class Message implements Serializable {
    private final static long serialVersionUID = 0L;

    private Integer message_id;
    private Integer message_thread_id;
    private User from;
    private Chat sender_chat;
    private Integer date;
    private Chat chat;
    private User forward_from;
    private Chat forward_from_chat;
    private Integer forward_from_message_id;
    private String forward_signature;
    private String forward_sender_name;
    private Integer forward_date;
    private Boolean is_topic_message;
    private Boolean is_automatic_forward;
    private Message reply_to_message;
    private User via_bot;
    private Integer edit_date;
    private Boolean has_protected_content;
    private Boolean has_media_spoiler;
    private String media_group_id;
    private String author_signature;
    private String text;
    private MessageEntity[] entities;
    private MessageEntity[] caption_entities;
    private Audio audio;
    private Document document;
    private Animation animation;
    private Game game;
    private PhotoSize[] photo;
    private Sticker sticker;
    private Video video;
    private Voice voice;
    private VideoNote video_note;
    private String caption;
    private Contact contact;
    private Location location;
    private Venue venue;
    private Poll poll;
    private Dice dice;
    private User[] new_chat_members;
    private User left_chat_member;
    private String new_chat_title;
    private PhotoSize[] new_chat_photo;
    private Boolean delete_chat_photo;
    private Boolean group_chat_created;
    private Boolean supergroup_chat_created;
    private Boolean channel_chat_created;
    private MessageAutoDeleteTimerChanged message_auto_delete_timer_changed;
    private Long migrate_to_chat_id;
    private Long migrate_from_chat_id;
    private Message pinned_message;
    private Invoice invoice;
    private SuccessfulPayment successful_payment;
    private Story story;
    private UserShared user_shared;
    private ChatShared chat_shared;
    private String connected_website;
    private PassportData passport_data;
    private ProximityAlertTriggered proximity_alert_triggered;
    private ForumTopicCreated forum_topic_created;
    private ForumTopicEdited forum_topic_edited;
    private ForumTopicClosed forum_topic_closed;
    private ForumTopicReopened forum_topic_reopened;
    private GeneralForumTopicHidden general_forum_topic_hidden;
    private GeneralForumTopicUnhidden general_forum_topic_unhidden;
    private GiveawayCreated giveaway_created;
    private Giveaway giveaway;
    private GiveawayWinners giveaway_winners;
    private GiveawayCompleted giveaway_completed;
    private WriteAccessAllowed write_access_allowed;

    private VideoChatStarted video_chat_started;
    private VideoChatEnded video_chat_ended;
    private VideoChatParticipantsInvited video_chat_participants_invited;
    private VideoChatScheduled video_chat_scheduled;
    private InlineKeyboardMarkup reply_markup;
    private WebAppData web_app_data;

    public Integer messageId() {
        return message_id;
    }

    public Integer messageThreadId() {
        return message_thread_id;
    }

    public User from() {
        return from;
    }

    public Chat senderChat() {
        return sender_chat;
    }

    public Integer date() {
        return date;
    }

    public Chat chat() {
        return chat;
    }

    public User forwardFrom() {
        return forward_from;
    }

    public Chat forwardFromChat() {
        return forward_from_chat;
    }

    public Integer forwardFromMessageId() {
        return forward_from_message_id;
    }

    public String forwardSignature() {
        return forward_signature;
    }

    public String forwardSenderName() {
        return forward_sender_name;
    }

    public Boolean isTopicMessage() {
        return is_topic_message != null && is_topic_message;
    }

    public Integer forwardDate() {
        return forward_date;
    }

    public Boolean isAutomaticForward() {
        return is_automatic_forward;
    }

    public Message replyToMessage() {
        return reply_to_message;
    }

    public User viaBot() {
        return via_bot;
    }

    public Integer editDate() {
        return edit_date;
    }

    public Boolean hasProtectedContent() {
        return has_protected_content;
    }

    public Boolean hasMediaSpoiler() {
        return has_media_spoiler;
    }


    public String mediaGroupId() {
        return media_group_id;
    }

    public String authorSignature() {
        return author_signature;
    }

    public String text() {
        return text;
    }

    public MessageEntity[] entities() {
        return entities;
    }

    public MessageEntity[] captionEntities() {
        return caption_entities;
    }

    public Audio audio() {
        return audio;
    }

    public Document document() {
        return document;
    }

    public Animation animation() {
        return animation;
    }

    public Game game() {
        return game;
    }

    public PhotoSize[] photo() {
        return photo;
    }

    public Sticker sticker() {
        return sticker;
    }

    public Video video() {
        return video;
    }

    public Voice voice() {
        return voice;
    }

    public VideoNote videoNote() {
        return video_note;
    }

    public String caption() {
        return caption;
    }

    public Contact contact() {
        return contact;
    }

    public Location location() {
        return location;
    }

    public Venue venue() {
        return venue;
    }

    public Poll poll() {
        return poll;
    }

    public Dice dice() {
        return dice;
    }

    public User[] newChatMembers() {
        return new_chat_members;
    }

    public User leftChatMember() {
        return left_chat_member;
    }

    public String newChatTitle() {
        return new_chat_title;
    }

    public PhotoSize[] newChatPhoto() {
        return new_chat_photo;
    }

    public Boolean deleteChatPhoto() {
        return delete_chat_photo;
    }

    public Boolean groupChatCreated() {
        return group_chat_created;
    }

    public Boolean supergroupChatCreated() {
        return supergroup_chat_created;
    }

    public Boolean channelChatCreated() {
        return channel_chat_created;
    }

    public MessageAutoDeleteTimerChanged messageAutoDeleteTimerChanged() {
        return message_auto_delete_timer_changed;
    }

    public Long migrateToChatId() {
        return migrate_to_chat_id;
    }

    public Long migrateFromChatId() {
        return migrate_from_chat_id;
    }

    public Message pinnedMessage() {
        return pinned_message;
    }

    public Invoice invoice() {
        return invoice;
    }

    public SuccessfulPayment successfulPayment() {
        return successful_payment;
    }

    public Story story() {
        return story;
    }

    public UserShared userShared() {
        return user_shared;
    }

    public ChatShared chatShared() {
        return chat_shared;
    }

    public String connectedWebsite() {
        return connected_website;
    }

    public PassportData passportData() {
        return passport_data;
    }

    public ProximityAlertTriggered proximityAlertTriggered() {
        return proximity_alert_triggered;
    }

    public ForumTopicCreated forumTopicCreated() {
        return forum_topic_created;
    }

    public ForumTopicEdited forumTopicEdited() {
        return forum_topic_edited;
    }

    public ForumTopicClosed forumTopicClosed() {
        return forum_topic_closed;
    }

    public ForumTopicReopened forumTopicReopened() {
        return forum_topic_reopened;
    }

    public GeneralForumTopicHidden generalForumTopicHidden() {
        return general_forum_topic_hidden;
    }

    public GeneralForumTopicUnhidden generalForumTopicUnhidden() {
        return general_forum_topic_unhidden;
    }

    public WriteAccessAllowed writeAccessAllowed() {
        return write_access_allowed;
    }

    public VideoChatStarted videoChatStarted() {
        return video_chat_started;
    }

    public VideoChatEnded videoChatEnded() {
        return video_chat_ended;
    }

    public VideoChatParticipantsInvited videoChatParticipantsInvited() {
        return video_chat_participants_invited;
    }

    public VideoChatScheduled videoChatScheduled() {
        return video_chat_scheduled;
    }

    public InlineKeyboardMarkup replyMarkup() {
        return reply_markup;
    }

    public WebAppData webAppData() {
        return web_app_data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return Objects.equals(message_id, message.message_id) &&
                Objects.equals(message_thread_id , message.message_thread_id ) &&
                Objects.equals(from, message.from) &&
                Objects.equals(sender_chat, message.sender_chat) &&
                Objects.equals(date, message.date) &&
                Objects.equals(chat, message.chat) &&
                Objects.equals(forward_from, message.forward_from) &&
                Objects.equals(forward_from_chat, message.forward_from_chat) &&
                Objects.equals(forward_from_message_id, message.forward_from_message_id) &&
                Objects.equals(forward_signature, message.forward_signature) &&
                Objects.equals(forward_sender_name, message.forward_sender_name) &&
                Objects.equals(forward_date, message.forward_date) &&
                Objects.equals(is_topic_message, message.is_topic_message) &&
                Objects.equals(is_automatic_forward, message.is_automatic_forward) &&
                Objects.equals(reply_to_message, message.reply_to_message) &&
                Objects.equals(via_bot, message.via_bot) &&
                Objects.equals(edit_date, message.edit_date) &&
                Objects.equals(has_protected_content, message.has_protected_content) &&
                Objects.equals(has_media_spoiler, message.has_media_spoiler) &&
                Objects.equals(media_group_id, message.media_group_id) &&
                Objects.equals(author_signature, message.author_signature) &&
                Objects.equals(text, message.text) &&
                Arrays.equals(entities, message.entities) &&
                Arrays.equals(caption_entities, message.caption_entities) &&
                Objects.equals(audio, message.audio) &&
                Objects.equals(document, message.document) &&
                Objects.equals(animation, message.animation) &&
                Objects.equals(game, message.game) &&
                Arrays.equals(photo, message.photo) &&
                Objects.equals(sticker, message.sticker) &&
                Objects.equals(video, message.video) &&
                Objects.equals(voice, message.voice) &&
                Objects.equals(video_note, message.video_note) &&
                Objects.equals(caption, message.caption) &&
                Objects.equals(contact, message.contact) &&
                Objects.equals(location, message.location) &&
                Objects.equals(venue, message.venue) &&
                Objects.equals(poll, message.poll) &&
                Objects.equals(dice, message.dice) &&
                Arrays.equals(new_chat_members, message.new_chat_members) &&
                Objects.equals(left_chat_member, message.left_chat_member) &&
                Objects.equals(new_chat_title, message.new_chat_title) &&
                Arrays.equals(new_chat_photo, message.new_chat_photo) &&
                Objects.equals(delete_chat_photo, message.delete_chat_photo) &&
                Objects.equals(group_chat_created, message.group_chat_created) &&
                Objects.equals(supergroup_chat_created, message.supergroup_chat_created) &&
                Objects.equals(channel_chat_created, message.channel_chat_created) &&
                Objects.equals(message_auto_delete_timer_changed, message.message_auto_delete_timer_changed) &&
                Objects.equals(migrate_to_chat_id, message.migrate_to_chat_id) &&
                Objects.equals(migrate_from_chat_id, message.migrate_from_chat_id) &&
                Objects.equals(pinned_message, message.pinned_message) &&
                Objects.equals(invoice, message.invoice) &&
                Objects.equals(successful_payment, message.successful_payment) &&
                Objects.equals(story, message.story) &&
                Objects.equals(user_shared, message.user_shared) &&
                Objects.equals(chat_shared, message.chat_shared) &&
                Objects.equals(connected_website, message.connected_website) &&
                Objects.equals(passport_data, message.passport_data) &&
                Objects.equals(proximity_alert_triggered, message.proximity_alert_triggered) &&
                Objects.equals(forum_topic_created, message.forum_topic_created) &&
                Objects.equals(forum_topic_edited, message.forum_topic_edited) &&
                Objects.equals(forum_topic_closed, message.forum_topic_closed) &&
                Objects.equals(forum_topic_reopened, message.forum_topic_reopened) &&
                Objects.equals(general_forum_topic_hidden, message.general_forum_topic_hidden) &&
                Objects.equals(general_forum_topic_unhidden, message.general_forum_topic_unhidden) &&
                Objects.equals(giveaway_created, message.giveaway_created) &&
                Objects.equals(giveaway, message.giveaway) &&
                Objects.equals(giveaway_winners, message.giveaway_winners) &&
                Objects.equals(giveaway_completed, message.giveaway_completed) &&
                Objects.equals(write_access_allowed, message.write_access_allowed) &&
                Objects.equals(video_chat_started, message.video_chat_started) &&
                Objects.equals(video_chat_ended, message.video_chat_ended) &&
                Objects.equals(video_chat_participants_invited, message.video_chat_participants_invited) &&
                Objects.equals(video_chat_scheduled, message.video_chat_scheduled) &&
                Objects.equals(reply_markup, message.reply_markup) &&
                Objects.equals(web_app_data, message.web_app_data);
    }

    @Override
    public int hashCode() {
        return message_id != null ? message_id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Message{" +
                "message_id=" + message_id +
                ", message_thread_id=" + message_thread_id +
                ", from=" + from +
                ", sender_chat=" + sender_chat +
                ", date=" + date +
                ", chat=" + chat +
                ", forward_from=" + forward_from +
                ", forward_from_chat=" + forward_from_chat +
                ", forward_from_message_id=" + forward_from_message_id +
                ", forward_signature='" + forward_signature + '\'' +
                ", forward_sender_name='" + forward_sender_name + '\'' +
                ", forward_date=" + forward_date +
                ", is_topic_message=" + is_topic_message +
                ", is_automatic_forward=" + is_automatic_forward +
                ", reply_to_message=" + reply_to_message +
                ", via_bot=" + via_bot +
                ", edit_date=" + edit_date +
                ", has_protected_content=" + has_protected_content+
                ", has_media_spoiler=" + has_media_spoiler+
                ", media_group_id='" + media_group_id + '\'' +
                ", author_signature='" + author_signature + '\'' +
                ", text='" + text + '\'' +
                ", entities=" + Arrays.toString(entities) +
                ", caption_entities=" + Arrays.toString(caption_entities) +
                ", audio=" + audio +
                ", document=" + document +
                ", animation=" + animation +
                ", game=" + game +
                ", photo=" + Arrays.toString(photo) +
                ", sticker=" + sticker +
                ", video=" + video +
                ", voice=" + voice +
                ", video_note=" + video_note +
                ", caption='" + caption + '\'' +
                ", contact=" + contact +
                ", location=" + location +
                ", venue=" + venue +
                ", poll=" + poll +
                ", dice=" + dice +
                ", new_chat_members=" + Arrays.toString(new_chat_members) +
                ", left_chat_member=" + left_chat_member +
                ", new_chat_title='" + new_chat_title + '\'' +
                ", new_chat_photo=" + Arrays.toString(new_chat_photo) +
                ", delete_chat_photo=" + delete_chat_photo +
                ", group_chat_created=" + group_chat_created +
                ", supergroup_chat_created=" + supergroup_chat_created +
                ", channel_chat_created=" + channel_chat_created +
                ", message_auto_delete_timer_changed=" + message_auto_delete_timer_changed +
                ", migrate_to_chat_id=" + migrate_to_chat_id +
                ", migrate_from_chat_id=" + migrate_from_chat_id +
                ", pinned_message=" + pinned_message +
                ", invoice=" + invoice +
                ", successful_payment=" + successful_payment +
                ", story=" + story +
                ", user_shared=" + user_shared +
                ", chat_shared=" + chat_shared +
                ", connected_website='" + connected_website + '\'' +
                ", passport_data=" + passport_data +
                ", proximity_alert_triggered=" + proximity_alert_triggered +
                ", forum_topic_created=" + forum_topic_created +
                ", forum_topic_edited=" + forum_topic_edited +
                ", forum_topic_closed=" + forum_topic_closed +
                ", forum_topic_reopened=" + forum_topic_reopened +
                ", general_forum_topic_hidden=" + general_forum_topic_hidden +
                ", general_forum_topic_unhidden=" + general_forum_topic_unhidden +
                ", giveaway_created=" + giveaway_created +
                ", giveaway=" + giveaway +
                ", giveaway_winners=" + giveaway_winners +
                ", giveaway_completed=" + giveaway_completed +
                ", write_access_allowed=" + write_access_allowed +
                ", video_chat_started=" + video_chat_started +
                ", video_chat_ended=" + video_chat_ended +
                ", video_chat_participants_invited=" + video_chat_participants_invited +
                ", video_chat_scheduled=" + video_chat_scheduled +
                ", reply_markup=" + reply_markup +
                ", web_app_data=" + web_app_data +
                '}';
    }
}
