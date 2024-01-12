package com.pengrad.telegrambot.model.chatboost;

import java.io.Serializable;
import java.util.Objects;


public class ChatBoostSourceGiveaway extends ChatBoostSource implements Serializable {
    private final static long serialVersionUID = 0L;

    public final static String CHAT_BOOST_TYPE = "giveaway";

    private Integer giveaway_message_id;
    private Boolean is_unclaimed;

    public Integer giveawayMessageId() {
        return giveaway_message_id;
    }
    public Boolean isUnclaimed() {
        return is_unclaimed != null && is_unclaimed;
    }

    @Override
    public int hashCode() {
        return Objects.hash(source, user, giveaway_message_id, is_unclaimed);
    }

    @Override
    public String toString() {
        return "ChatBoostSourceGiveaway{" +
                "source='" + source + "'," +
                "user='" + user + "'," +
                "giveaway_message_id='" + giveaway_message_id + "'," +
                "is_unclaimed='" + is_unclaimed + "'" +
                '}';
    }

}
