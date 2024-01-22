package com.pengrad.telegrambot.model;

import com.pengrad.telegrambot.model.reaction.ReactionCount;

import java.util.Arrays;
import java.util.Objects;

public class MessageReactionCountUpdated {

    private Chat chat;
    private Integer message_id;
    private Integer date;
    private ReactionCount[] reactions;

    public Chat chat() {
        return chat;
    }

    public Integer messageId() {
        return message_id;
    }

    public Integer date() {
        return date;
    }

    public ReactionCount[] reactions() {
        return reactions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageReactionCountUpdated that = (MessageReactionCountUpdated) o;
        return Objects.equals(chat, that.chat) &&
                Objects.equals(message_id, that.message_id) &&
                Objects.equals(date, that.date) &&
                Arrays.equals(reactions, that.reactions);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(chat, message_id, date);
        result = 31 * result + Arrays.hashCode(reactions);
        return result;
    }

    @Override
    public String toString() {
        return "MessageReactionCountUpdated{" +
            "chat=" + chat +
            ", message_id=" + message_id +
            ", date=" + date +
            ", reactions=" + Arrays.toString(reactions) +
            '}';
    }
}
