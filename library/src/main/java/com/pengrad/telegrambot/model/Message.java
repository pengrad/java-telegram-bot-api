package com.pengrad.telegrambot.model;

import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;
import com.pengrad.telegrambot.passport.PassportData;

import java.io.Serializable;
import java.util.Arrays;

/**
 * stas
 * 8/4/15.
 */
public class Message implements Serializable {
    private final static long serialVersionUID = 0L;

    private Integer message_id;
    private User from;
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
    private Long migrate_to_chat_id;
    private Long migrate_from_chat_id;
    private Message pinned_message;
    private Invoice invoice;
    private SuccessfulPayment successful_payment;
    private String connected_website;
    private PassportData passport_data;
    private InlineKeyboardMarkup reply_markup;

    public Integer messageId() {
        return message_id;
    }

    public User from() {
        return from;
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

    public InlineKeyboardMarkup replyMarkup() {
        return reply_markup;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Message message = (Message) o;

        if (message_id != null ? !message_id.equals(message.message_id) : message.message_id != null) return false;
        if (from != null ? !from.equals(message.from) : message.from != null) return false;
        if (date != null ? !date.equals(message.date) : message.date != null) return false;
        if (chat != null ? !chat.equals(message.chat) : message.chat != null) return false;
        if (forward_from != null ? !forward_from.equals(message.forward_from) : message.forward_from != null)
            return false;
        if (forward_from_chat != null ? !forward_from_chat.equals(message.forward_from_chat) : message.forward_from_chat != null)
            return false;
        if (forward_from_message_id != null ? !forward_from_message_id.equals(message.forward_from_message_id) : message.forward_from_message_id != null)
            return false;
        if (forward_signature != null ? !forward_signature.equals(message.forward_signature) : message.forward_signature != null)
            return false;
        if (forward_sender_name != null ? !forward_sender_name.equals(message.forward_sender_name) : message.forward_sender_name != null)
            return false;
        if (forward_date != null ? !forward_date.equals(message.forward_date) : message.forward_date != null)
            return false;
        if (reply_to_message != null ? !reply_to_message.equals(message.reply_to_message) : message.reply_to_message != null)
            return false;
        if (via_bot != null ? !via_bot.equals(message.via_bot) : message.via_bot != null) return false;
        if (edit_date != null ? !edit_date.equals(message.edit_date) : message.edit_date != null) return false;
        if (media_group_id != null ? !media_group_id.equals(message.media_group_id) : message.media_group_id != null)
            return false;
        if (author_signature != null ? !author_signature.equals(message.author_signature) : message.author_signature != null)
            return false;
        if (text != null ? !text.equals(message.text) : message.text != null) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(entities, message.entities)) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(caption_entities, message.caption_entities)) return false;
        if (audio != null ? !audio.equals(message.audio) : message.audio != null) return false;
        if (document != null ? !document.equals(message.document) : message.document != null) return false;
        if (animation != null ? !animation.equals(message.animation) : message.animation != null) return false;
        if (game != null ? !game.equals(message.game) : message.game != null) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(photo, message.photo)) return false;
        if (sticker != null ? !sticker.equals(message.sticker) : message.sticker != null) return false;
        if (video != null ? !video.equals(message.video) : message.video != null) return false;
        if (voice != null ? !voice.equals(message.voice) : message.voice != null) return false;
        if (video_note != null ? !video_note.equals(message.video_note) : message.video_note != null) return false;
        if (caption != null ? !caption.equals(message.caption) : message.caption != null) return false;
        if (contact != null ? !contact.equals(message.contact) : message.contact != null) return false;
        if (location != null ? !location.equals(message.location) : message.location != null) return false;
        if (venue != null ? !venue.equals(message.venue) : message.venue != null) return false;
        if (poll != null ? !poll.equals(message.poll) : message.poll != null) return false;
        if (dice != null ? !dice.equals(message.dice) : message.dice != null) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(new_chat_members, message.new_chat_members)) return false;
        if (left_chat_member != null ? !left_chat_member.equals(message.left_chat_member) : message.left_chat_member != null)
            return false;
        if (new_chat_title != null ? !new_chat_title.equals(message.new_chat_title) : message.new_chat_title != null)
            return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(new_chat_photo, message.new_chat_photo)) return false;
        if (delete_chat_photo != null ? !delete_chat_photo.equals(message.delete_chat_photo) : message.delete_chat_photo != null)
            return false;
        if (group_chat_created != null ? !group_chat_created.equals(message.group_chat_created) : message.group_chat_created != null)
            return false;
        if (supergroup_chat_created != null ? !supergroup_chat_created.equals(message.supergroup_chat_created) : message.supergroup_chat_created != null)
            return false;
        if (channel_chat_created != null ? !channel_chat_created.equals(message.channel_chat_created) : message.channel_chat_created != null)
            return false;
        if (migrate_to_chat_id != null ? !migrate_to_chat_id.equals(message.migrate_to_chat_id) : message.migrate_to_chat_id != null)
            return false;
        if (migrate_from_chat_id != null ? !migrate_from_chat_id.equals(message.migrate_from_chat_id) : message.migrate_from_chat_id != null)
            return false;
        if (pinned_message != null ? !pinned_message.equals(message.pinned_message) : message.pinned_message != null)
            return false;
        if (invoice != null ? !invoice.equals(message.invoice) : message.invoice != null) return false;
        if (successful_payment != null ? !successful_payment.equals(message.successful_payment) : message.successful_payment != null)
            return false;
        if (connected_website != null ? !connected_website.equals(message.connected_website) : message.connected_website != null)
            return false;
        if (passport_data != null ? !passport_data.equals(message.passport_data) : message.passport_data != null)
            return false;
        return reply_markup != null ? reply_markup.equals(message.reply_markup) : message.reply_markup == null;
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
                ", migrate_to_chat_id=" + migrate_to_chat_id +
                ", migrate_from_chat_id=" + migrate_from_chat_id +
                ", pinned_message=" + pinned_message +
                ", invoice=" + invoice +
                ", successful_payment=" + successful_payment +
                ", connected_website='" + connected_website + '\'' +
                ", passport_data=" + passport_data +
                ", reply_markup=" + reply_markup +
                '}';
    }
}
