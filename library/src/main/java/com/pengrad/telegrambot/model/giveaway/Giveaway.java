package com.pengrad.telegrambot.model.giveaway;

import com.pengrad.telegrambot.model.Chat;

import java.util.Arrays;
import java.util.Objects;

public class Giveaway {

    private Chat[] chats;
    private Integer winners_selection_date;
    private Integer winner_count;
    private Boolean only_new_members;
    private Boolean has_public_winners;
    private String prize_description;
    private String[] country_codes;
    private Integer premium_subscription_month_count;

    public Chat[] chats() {
        return chats;
    }

    public Integer winnersSelectionDate() {
        return winners_selection_date;
    }

    public Integer winnerCount() {
        return winner_count;
    }

    public Boolean onlyNewMembers() {
        return only_new_members;
    }

    public Boolean hasPublicWinners() {
        return has_public_winners;
    }

    public String prizeDescription() {
        return prize_description;
    }

    public String[] countryCodes() {
        return country_codes;
    }

    public Integer premiumSubscriptionMonthCount() {
        return premium_subscription_month_count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Giveaway giveaway = (Giveaway) o;
        return Arrays.equals(chats, giveaway.chats) &&
                Objects.equals(winners_selection_date, giveaway.winners_selection_date) &&
                Objects.equals(winner_count, giveaway.winner_count) &&
                Objects.equals(only_new_members, giveaway.only_new_members) &&
                Objects.equals(has_public_winners, giveaway.has_public_winners) &&
                Objects.equals(prize_description, giveaway.prize_description) &&
                Arrays.equals(country_codes, giveaway.country_codes) &&
                Objects.equals(premium_subscription_month_count, giveaway.premium_subscription_month_count);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(winners_selection_date, winner_count, only_new_members, has_public_winners, prize_description, premium_subscription_month_count);
        result = 31 * result + Arrays.hashCode(chats);
        result = 31 * result + Arrays.hashCode(country_codes);
        return result;
    }

    @Override
    public String toString() {
        return "Giveaway{" +
            "chats=" + Arrays.toString(chats) +
            ", winners_selection_date=" + winners_selection_date +
            ", winner_count=" + winner_count +
            ", only_new_members=" + only_new_members +
            ", has_public_winners=" + has_public_winners +
            ", prize_description='" + prize_description + '\'' +
            ", country_codes=" + Arrays.toString(country_codes) +
            ", premium_subscription_month_count=" + premium_subscription_month_count +
            '}';
    }
}
