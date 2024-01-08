package com.pengrad.telegrambot.model;

import com.pengrad.telegrambot.model.reaction.ReactionType;

import java.util.Arrays;
import java.util.Objects;

public class MessageReactionUpdated {

    private Chat chat;
    private Integer message_id;
    private User user;
    private Chat actor_chat;
    private Integer date;
    private ReactionType[] old_reaction;
    private ReactionType[] new_reaction;

    public Chat chat() {
        return chat;
    }

    public Integer messageId() {
        return message_id;
    }

    public User user() {
        return user;
    }

    public Chat actorChat() {
        return actor_chat;
    }

    public Integer date() {
        return date;
    }

    public ReactionType[] oldReaction() {
        return old_reaction;
    }

    public ReactionType[] newReaction() {
        return new_reaction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageReactionUpdated that = (MessageReactionUpdated) o;
        return Objects.equals(chat, that.chat) &&
                Objects.equals(message_id, that.message_id) &&
                Objects.equals(user, that.user) &&
                Objects.equals(actor_chat, that.actor_chat) &&
                Objects.equals(date, that.date) &&
                Arrays.equals(old_reaction, that.old_reaction) &&
                Arrays.equals(new_reaction, that.new_reaction);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(chat, message_id, user, actor_chat, date);
        result = 31 * result + Arrays.hashCode(old_reaction);
        result = 31 * result + Arrays.hashCode(new_reaction);
        return result;
    }

    @Override
    public String toString() {
        return "MessageReactionUpdated{" +
            "chat=" + chat +
            ", message_id=" + message_id +
            ", user=" + user +
            ", actor_chat=" + actor_chat +
            ", date=" + date +
            ", old_reaction=" + Arrays.toString(old_reaction) +
            ", new_reaction=" + Arrays.toString(new_reaction) +
            '}';
    }
}
