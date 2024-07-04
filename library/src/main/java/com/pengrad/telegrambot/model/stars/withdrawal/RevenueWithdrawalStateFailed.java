package com.pengrad.telegrambot.model.stars.withdrawal;

public class RevenueWithdrawalStateFailed extends RevenueWithdrawalState {

    public static final String TYPE = "failed";


    public RevenueWithdrawalStateFailed() {
        super(TYPE);
    }

    @Override
    public String toString() {
        return "RevenueWithdrawalStateFailed{" +
                "type='" + type() + '\'' +
                '}';
    }

}
