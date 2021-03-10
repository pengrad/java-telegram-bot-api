package com.pengrad.telegrambot.model;

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
    private Message reply_to_message;
    private User via_bot;
    private Integer edit_date;
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
    private String connected_website;
    private PassportData passport_data;
    private ProximityAlertTriggered proximity_alert_triggered;
    private VoiceChatStarted voice_chat_started;
    private VoiceChatEnded voice_chat_ended;
    private VoiceChatParticipantsInvited voice_chat_participants_invited;
    private InlineKeyboardMarkup reply_markup;

    public Integer messageId() {
        return message_id;
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

    public Integer forwardDate() {
        return forward_date;
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

    public String connectedWebsite() {
        return connected_website;
    }

    public PassportData passportData() {
        return passport_data;
    }

    public ProximityAlertTriggered proximityAlertTriggered() {
        return proximity_alert_triggered;
    }

    public VoiceChatStarted voiceChatStarted() {
        return voice_chat_started;
    }

    public VoiceChatEnded voiceChatEnded() {
        return voice_chat_ended;
    }

    public VoiceChatParticipantsInvited voiceChatParticipantsInvited() {
        return voice_chat_participants_invited;
    }

    public InlineKeyboardMarkup replyMarkup() {
        return reply_markup;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return Objects.equals(message_id, message.message_id) &&
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
                Objects.equals(reply_to_message, message.reply_to_message) &&
                Objects.equals(via_bot, message.via_bot) &&
                Objects.equals(edit_date, message.edit_date) &&
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
                Objects.equals(connected_website, message.connected_website) &&
                Objects.equals(passport_data, message.passport_data) &&
                Objects.equals(proximity_alert_triggered, message.proximity_alert_triggered) &&
                Objects.equals(voice_chat_started, message.voice_chat_started) &&
                Objects.equals(voice_chat_ended, message.voice_chat_ended) &&
                Objects.equals(voice_chat_participants_invited, message.voice_chat_participants_invited) &&
                Objects.equals(reply_markup, message.reply_markup);
    }

    @Override
    public int hashCode() {
        return message_id != null ? message_id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Message{" +
                "message_id=" + message_id +
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
                ", reply_to_message=" + reply_to_message +
                ", via_bot=" + via_bot +
                ", edit_date=" + edit_date +
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
                ", connected_website='" + connected_website + '\'' +
                ", passport_data=" + passport_data +
                ", proximity_alert_triggered=" + proximity_alert_triggered +
                ", voice_chat_started=" + voice_chat_started +
                ", voice_chat_ended=" + voice_chat_ended +
                ", voice_chat_participants_invited=" + voice_chat_participants_invited +
                ", reply_markup=" + reply_markup +
                '}';
    }
}
