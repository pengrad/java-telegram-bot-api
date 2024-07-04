package com.pengrad.telegrambot.model.stars.withdrawal;

public class RevenueWithdrawalStatePending extends RevenueWithdrawalState {

    public static final String TYPE = "pending";


    public RevenueWithdrawalStatePending() {
        super(TYPE);
    }

    @Override
    public String toString() {
        return "RevenueWithdrawalStatePending{" +
                "type='" + type() + '\'' +
                '}';
    }

}
