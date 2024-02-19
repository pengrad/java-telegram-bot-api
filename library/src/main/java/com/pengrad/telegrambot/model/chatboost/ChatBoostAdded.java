package com.pengrad.telegrambot.model.chatboost;

import java.util.Objects;

public class ChatBoostAdded {

    private Integer boost_count;

    public Integer boostCount() {
        return boost_count;
    }

    public ChatBoostAdded boostCount(Integer boostCount) {
        this.boost_count = boostCount;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChatBoostAdded that = (ChatBoostAdded) o;
        return Objects.equals(boost_count, that.boost_count);
    }

    @Override
    public int hashCode() {
        return Objects.hash(boost_count);
    }

    @Override
    public String toString() {
        return "ChatBoostAdded{" +
            "boost_count=" + boost_count +
            '}';
    }
}
