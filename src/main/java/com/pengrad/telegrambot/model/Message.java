package com.pengrad.telegrambot.model;

import java.util.Arrays;

/**
 * stas
 * 8/4/15.
 */
public class Message {

    private final Integer message_id;
    private final User from;
    private final Integer date;
    private final Chat chat;
    private final User forward_from;
    private final Integer forward_date;
    private final Message reply_to_message;
    private final String text;
    private final Audio audio;
    private final Document document;
    private final PhotoSize[] photo;
    private final Sticker sticker;
    private final Video video;
    private final Voice voice;
    private final String caption;
    private final Contact contact;
    private final Location location;
    private final User new_chat_participant;
    private final User left_chat_participant;
    private final String new_chat_title;
    private final PhotoSize[] new_chat_photo;
    private final Boolean delete_chat_photo;
    private final Boolean group_chat_created;

    public Message(Integer message_id, User from, Integer date, Chat chat, User forward_from, Integer forward_date,
                   Message reply_to_message, String text, Audio audio, Document document, PhotoSize[] photo,
                   Sticker sticker, Video video, Voice voice, String caption, Contact contact, Location location,
                   User new_chat_participant, User left_chat_participant, String new_chat_title,
                   PhotoSize[] new_chat_photo, Boolean delete_chat_photo, Boolean group_chat_created) {
        this.message_id = message_id;
        this.from = from;
        this.date = date;
        this.chat = chat;
        this.forward_from = forward_from;
        this.forward_date = forward_date;
        this.reply_to_message = reply_to_message;
        this.text = text;
        this.audio = audio;
        this.document = document;
        this.photo = photo;
        this.sticker = sticker;
        this.video = video;
        this.voice = voice;
        this.caption = caption;
        this.contact = contact;
        this.location = location;
        this.new_chat_participant = new_chat_participant;
        this.left_chat_participant = left_chat_participant;
        this.new_chat_title = new_chat_title;
        this.new_chat_photo = new_chat_photo;
        this.delete_chat_photo = delete_chat_photo;
        this.group_chat_created = group_chat_created;
    }


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

    public Integer forwardDate() {
        return forward_date;
    }

    public Message replyToMessage() {
        return reply_to_message;
    }

    public String text() {
        return text;
    }

    public Audio audio() {
        return audio;
    }

    public Document document() {
        return document;
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

    public String caption() {
        return caption;
    }

    public Contact contact() {
        return contact;
    }

    public Location location() {
        return location;
    }

    public User newChatParticipant() {
        return new_chat_participant;
    }

    public User leftChatParticipant() {
        return left_chat_participant;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Message message = (Message) o;

        if (!message_id.equals(message.message_id)) return false;
        if (from != null ? !from.equals(message.from) : message.from != null) return false;
        if (!date.equals(message.date)) return false;
        if (!chat.equals(message.chat)) return false;
        if (forward_from != null ? !forward_from.equals(message.forward_from) : message.forward_from != null)
            return false;
        if (forward_date != null ? !forward_date.equals(message.forward_date) : message.forward_date != null)
            return false;
        if (reply_to_message != null ? !reply_to_message.equals(message.reply_to_message) : message.reply_to_message != null)
            return false;
        if (text != null ? !text.equals(message.text) : message.text != null) return false;
        if (audio != null ? !audio.equals(message.audio) : message.audio != null) return false;
        if (document != null ? !document.equals(message.document) : message.document != null) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(photo, message.photo)) return false;
        if (sticker != null ? !sticker.equals(message.sticker) : message.sticker != null) return false;
        if (video != null ? !video.equals(message.video) : message.video != null) return false;
        if (voice != null ? !voice.equals(message.voice) : message.voice != null) return false;
        if (caption != null ? !caption.equals(message.caption) : message.caption != null) return false;
        if (contact != null ? !contact.equals(message.contact) : message.contact != null) return false;
        if (location != null ? !location.equals(message.location) : message.location != null) return false;
        if (new_chat_participant != null ? !new_chat_participant.equals(message.new_chat_participant) : message.new_chat_participant != null)
            return false;
        if (left_chat_participant != null ? !left_chat_participant.equals(message.left_chat_participant) : message.left_chat_participant != null)
            return false;
        if (new_chat_title != null ? !new_chat_title.equals(message.new_chat_title) : message.new_chat_title != null)
            return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(new_chat_photo, message.new_chat_photo)) return false;
        if (delete_chat_photo != null ? !delete_chat_photo.equals(message.delete_chat_photo) : message.delete_chat_photo != null)
            return false;
        return !(group_chat_created != null ? !group_chat_created.equals(message.group_chat_created) : message.group_chat_created != null);

    }

    @Override
    public int hashCode() {
        return message_id.hashCode();
    }

    @Override
    public String toString() {
        return "Message{" +
                "message_id=" + message_id +
                ", from=" + from +
                ", date=" + date +
                ", chat=" + chat +
                ", forward_from=" + forward_from +
                ", forward_date=" + forward_date +
                ", reply_to_message=" + reply_to_message +
                ", text='" + text + '\'' +
                ", audio=" + audio +
                ", document=" + document +
                ", photo=" + Arrays.toString(photo) +
                ", sticker=" + sticker +
                ", video=" + video +
                ", voice=" + voice +
                ", caption='" + caption + '\'' +
                ", contact=" + contact +
                ", location=" + location +
                ", new_chat_participant=" + new_chat_participant +
                ", left_chat_participant=" + left_chat_participant +
                ", new_chat_title='" + new_chat_title + '\'' +
                ", new_chat_photo=" + Arrays.toString(new_chat_photo) +
                ", delete_chat_photo=" + delete_chat_photo +
                ", group_chat_created=" + group_chat_created +
                '}';
    }
}
