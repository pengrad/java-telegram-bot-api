package com.pengrad.telegrambot.model.giveaway;

import com.pengrad.telegrambot.model.chat.Chat;

import java.io.Serializable;
import java.util.Objects;

public class Giveaway implements Serializable {

    private final static long serialVersionUID = 0L;

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
        Giveaway that = (Giveaway) o;
        return Objects.equals(chats, that.chats)
                && Objects.equals(winners_selection_date, that.winners_selection_date)
                && Objects.equals(winner_count, that.winner_count)
                && Objects.equals(only_new_members, that.only_new_members)
                && Objects.equals(has_public_winners, that.has_public_winners)
                && Objects.equals(prize_description, that.prize_description)
                && Objects.equals(country_codes, that.country_codes)
                && Objects.equals(premium_subscription_month_count, that.premium_subscription_month_count);
    }

    @Override
    public int hashCode() {
        return Objects.hash(chats, winners_selection_date, winner_count, only_new_members, has_public_winners, prize_description, country_codes, premium_subscription_month_count);
    }

    @Override
    public String toString() {
        return "Giveaway{" +
                "chats='" + chats + "'," +
                "winners_selection_date='" + winners_selection_date + "'," +
                "winner_count='" + winner_count + "'," +
                "only_new_members='" + only_new_members + "'," +
                "has_public_winners='" + has_public_winners + "'," +
                "prize_description='" + prize_description + "'," +
                "country_codes='" + country_codes + "'," +
                "premium_subscription_month_count='" + premium_subscription_month_count + "'" +
                '}';
    }


}
