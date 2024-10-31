package com.pengrad.telegrambot.model.giveaway;

import com.pengrad.telegrambot.model.Message;

import java.io.Serializable;
import java.util.Objects;

public class GiveawayCompleted implements Serializable {

    private final static long serialVersionUID = 0L;

    private Integer winner_count;
    private Integer unclaimed_prize_count;
    private Message giveaway_message;
    private Boolean is_star_giveaway;

    public Integer winnerCount() {
        return winner_count;
    }

    public Integer unclaimedPrizeCount() {
        return unclaimed_prize_count;
    }

    public Message giveawayMessage() {
        return giveaway_message;
    }

    public Boolean isStarGiveaway() {
        return is_star_giveaway;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GiveawayCompleted that = (GiveawayCompleted) o;
        return Objects.equals(winner_count, that.winner_count)
                && Objects.equals(unclaimed_prize_count, that.unclaimed_prize_count)
                && Objects.equals(giveaway_message, that.giveaway_message)
                && Objects.equals(is_star_giveaway, that.is_star_giveaway);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            winner_count,
            unclaimed_prize_count,
            giveaway_message,
            is_star_giveaway);
    }

    @Override
    public String toString() {
        return "GiveawayCompleted{" +
                "winner_count='" + winner_count + "'," +
                "unclaimed_prize_count='" + unclaimed_prize_count + "'," +
                "giveaway_message='" + giveaway_message + "'" +
                "is_star_giveaway='" + is_star_giveaway + "'" +
                '}';
    }

}
