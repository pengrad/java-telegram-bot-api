package com.pengrad.telegrambot.model.giveaway;

import com.pengrad.telegrambot.model.Chat;
import com.pengrad.telegrambot.model.User;

import java.util.Arrays;
import java.util.Objects;

public class GiveawayWinners {

    private Chat chat;
    private Integer giveaway_message_id;
    private Integer winners_selection_date;
    private Integer winner_count;
    private User[] winners;
    private Integer additional_chat_count;
    private Integer premium_subscription_month_count;
    private Integer unclaimed_prize_count;
    private Boolean only_new_members;
    private Boolean was_refunded;
    private String prize_description;

    public Chat chat() {
        return chat;
    }

    public Integer giveawayMessageId() {
        return giveaway_message_id;
    }

    public Integer winnersSelectionDate() {
        return winners_selection_date;
    }

    public Integer winnerCount() {
        return winner_count;
    }

    public User[] winners() {
        return winners;
    }

    public Integer additionalChatCount() {
        return additional_chat_count;
    }

    public Integer premiumSubscriptionMonthCount() {
        return premium_subscription_month_count;
    }

    public Integer unclaimedPrizeCount() {
        return unclaimed_prize_count;
    }

    public Boolean onlyNewMembers() {
        return only_new_members;
    }

    public Boolean wasRefunded() {
        return was_refunded;
    }

    public String prizeDescription() {
        return prize_description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GiveawayWinners that = (GiveawayWinners) o;
        return Objects.equals(chat, that.chat) &&
                Objects.equals(giveaway_message_id, that.giveaway_message_id) &&
                Objects.equals(winners_selection_date, that.winners_selection_date) &&
                Objects.equals(winner_count, that.winner_count) &&
                Arrays.equals(winners, that.winners) &&
                Objects.equals(additional_chat_count, that.additional_chat_count) &&
                Objects.equals(premium_subscription_month_count, that.premium_subscription_month_count) &&
                Objects.equals(unclaimed_prize_count, that.unclaimed_prize_count) &&
                Objects.equals(only_new_members, that.only_new_members) &&
                Objects.equals(was_refunded, that.was_refunded) &&
                Objects.equals(prize_description, that.prize_description);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(chat, giveaway_message_id, winners_selection_date, winner_count, additional_chat_count, premium_subscription_month_count, unclaimed_prize_count, only_new_members, was_refunded, prize_description);
        result = 31 * result + Arrays.hashCode(winners);
        return result;
    }

    @Override
    public String toString() {
        return "GiveawayWinners{" +
            "chat=" + chat +
            ", giveaway_message_id=" + giveaway_message_id +
            ", winners_selection_date=" + winners_selection_date +
            ", winner_count=" + winner_count +
            ", winners=" + Arrays.toString(winners) +
            ", additional_chat_count=" + additional_chat_count +
            ", premium_subscription_month_count=" + premium_subscription_month_count +
            ", unclaimed_prize_count=" + unclaimed_prize_count +
            ", only_new_members=" + only_new_members +
            ", was_refunded=" + was_refunded +
            ", prize_description='" + prize_description + '\'' +
            '}';
    }
}
