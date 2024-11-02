package com.pengrad.telegrambot.model.chatboost.source;

import java.io.Serializable;
import java.util.Objects;


public class ChatBoostSourceGiveaway extends ChatBoostSource implements Serializable {
    private final static long serialVersionUID = 0L;

    public final static String CHAT_BOOST_TYPE = "giveaway";

    private Integer giveaway_message_id;
    private Boolean is_unclaimed;
    private Integer prize_star_count;

    public Integer giveawayMessageId() {
        return giveaway_message_id;
    }

    public Boolean isUnclaimed() {
        return is_unclaimed != null && is_unclaimed;
    }

    public Integer prizeStarCount() {
        return prize_star_count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ChatBoostSourceGiveaway that = (ChatBoostSourceGiveaway) o;
        return Objects.equals(giveaway_message_id, that.giveaway_message_id)
            && Objects.equals(is_unclaimed, that.is_unclaimed)
            && Objects.equals(prize_star_count, that.prize_star_count);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            super.hashCode(),
            giveaway_message_id,
            is_unclaimed,
            prize_star_count);
    }

    @Override
    public String toString() {
        return "ChatBoostSourceGiveaway{" +
                "source='" + source + "'," +
                "user='" + user + "'," +
                "giveaway_message_id='" + giveaway_message_id + "'," +
                "is_unclaimed='" + is_unclaimed + "'," +
                "prize_star_count='" + prize_star_count + "'" +
                '}';
    }

}
