package com.pengrad.telegrambot.model;

import com.pengrad.telegrambot.model.giveaway.Giveaway;
import com.pengrad.telegrambot.model.giveaway.GiveawayWinners;
import com.pengrad.telegrambot.model.message.origin.MessageOrigin;
import com.pengrad.telegrambot.model.paidmedia.PaidMediaInfo;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;


public class ExternalReplyInfo implements Serializable {
    private final static long serialVersionUID = 0L;

    private MessageOrigin origin;
    private Chat chat;
    private Integer message_id;
    private LinkPreviewOptions link_preview_options;
    private Animation animation;
    private Audio audio;
    private PaidMediaInfo paid_media;
    private Document document;
    private PhotoSize[] photo;
    private Sticker sticker;
    private Story story;
    private Video video;
    private VideoNote video_note;
    private Voice voice;
    private Boolean has_media_spoiler;
    private Contact contact;
    private Dice dice;
    private Game game;
    private Giveaway giveaway;
    private GiveawayWinners giveaway_winners;
    private Invoice invoice;
    private Location location;
    private Poll poll;
    private Venue venue;

    public MessageOrigin origin() {
        return origin;
    }

    public Chat chat() {
        return chat;
    }

    public Integer messageId() {
        return message_id;
    }

    public LinkPreviewOptions linkPreviewOptions() {
        return link_preview_options;
    }

    public Animation animation() {
        return animation;
    }

    public Audio audio() {
        return audio;
    }

    public PaidMediaInfo paidMedia() {
        return paid_media;
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

    public Story story() {
        return story;
    }

    public Video video() {
        return video;
    }

    public VideoNote videoNote() {
        return video_note;
    }

    public Voice voice() {
        return voice;
    }

    public Boolean hasMediaSpoiler() {
        return has_media_spoiler;
    }

    public Contact contact() {
        return contact;
    }

    public Dice dice() {
        return dice;
    }

    public Game game() {
        return game;
    }

    public Giveaway giveaway() {
        return giveaway;
    }

    public GiveawayWinners giveawayWinners() {
        return giveaway_winners;
    }

    public Invoice invoice() {
        return invoice;
    }

    public Location location() {
        return location;
    }

    public Poll poll() {
        return poll;
    }

    public Venue venue() {
        return venue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExternalReplyInfo that = (ExternalReplyInfo) o;
        return Objects.equals(origin, that.origin) && Objects.equals(chat, that.chat) && Objects.equals(message_id, that.message_id) && Objects.equals(link_preview_options, that.link_preview_options) && Objects.equals(animation, that.animation) && Objects.equals(audio, that.audio) && Objects.equals(paid_media, that.paid_media) && Objects.equals(document, that.document) && Arrays.equals(photo, that.photo) && Objects.equals(sticker, that.sticker) && Objects.equals(story, that.story) && Objects.equals(video, that.video) && Objects.equals(video_note, that.video_note) && Objects.equals(voice, that.voice) && Objects.equals(has_media_spoiler, that.has_media_spoiler) && Objects.equals(contact, that.contact) && Objects.equals(dice, that.dice) && Objects.equals(game, that.game) && Objects.equals(giveaway, that.giveaway) && Objects.equals(giveaway_winners, that.giveaway_winners) && Objects.equals(invoice, that.invoice) && Objects.equals(location, that.location) && Objects.equals(poll, that.poll) && Objects.equals(venue, that.venue);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(origin, chat, message_id, link_preview_options, animation, audio, paid_media, document, sticker, story, video, video_note, voice, has_media_spoiler, contact, dice, game, giveaway, giveaway_winners, invoice, location, poll, venue);
        result = 31 * result + Arrays.hashCode(photo);
        return result;
    }

    @Override
    public String toString() {
        return "ExternalReplyInfo{" +
                "origin=" + origin +
                ", chat=" + chat +
                ", message_id=" + message_id +
                ", link_preview_options=" + link_preview_options +
                ", animation=" + animation +
                ", audio=" + audio +
                ", paid_media=" + paid_media +
                ", document=" + document +
                ", photo=" + Arrays.toString(photo) +
                ", sticker=" + sticker +
                ", story=" + story +
                ", video=" + video +
                ", video_note=" + video_note +
                ", voice=" + voice +
                ", has_media_spoiler=" + has_media_spoiler +
                ", contact=" + contact +
                ", dice=" + dice +
                ", game=" + game +
                ", giveaway=" + giveaway +
                ", giveaway_winners=" + giveaway_winners +
                ", invoice=" + invoice +
                ", location=" + location +
                ", poll=" + poll +
                ", venue=" + venue +
                '}';
    }
}
