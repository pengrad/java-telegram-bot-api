package com.pengrad.telegrambot.model.chatboost;

import com.pengrad.telegrambot.model.chatboost.source.ChatBoostSource;

import java.util.Objects;

public class ChatBoost {

    private String boost_id;
    private Integer add_date;
    private Integer expiration_date;
    private ChatBoostSource source;

    public String boostId() {
        return boost_id;
    }

    public Integer addDate() {
        return add_date;
    }

    public Integer expirationDate() {
        return expiration_date;
    }

    public ChatBoostSource source() {
        return source;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChatBoost chatBoost = (ChatBoost) o;
        return Objects.equals(boost_id, chatBoost.boost_id)
                && Objects.equals(add_date, chatBoost.add_date)
                && Objects.equals(expiration_date, chatBoost.expiration_date)
                && Objects.equals(source, chatBoost.source);
    }

    @Override
    public int hashCode() {
        return boost_id != null ? boost_id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "ChatBoost{" +
            "boost_id='" + boost_id + '\'' +
            ", add_date=" + add_date +
            ", expiration_date=" + expiration_date +
            ", source=" + source +
            '}';
    }
}
