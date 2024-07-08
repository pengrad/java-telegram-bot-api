package com.pengrad.telegrambot.model.stars.withdrawal;

import com.pengrad.telegrambot.model.chatbackground.BackgroundFill;

import java.io.Serializable;
import java.util.Objects;

public abstract class RevenueWithdrawalState implements Serializable {

    private final static long serialVersionUID = 0L;

    private String type = "unknown";

    protected RevenueWithdrawalState(String type) {
        this.type = type;
    }

    public String type() {
        return type;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RevenueWithdrawalState that = (RevenueWithdrawalState) o;
        return Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }

    @Override
    public String toString() {
        return "RevenueWithdrawalState{" +
                "type='" + type + '\'' +
                '}';
    }

}
