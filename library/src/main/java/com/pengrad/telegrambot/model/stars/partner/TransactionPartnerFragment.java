package com.pengrad.telegrambot.model.stars.partner;

import com.pengrad.telegrambot.model.stars.withdrawal.RevenueWithdrawalState;

import java.util.Objects;

public class TransactionPartnerFragment extends TransactionPartner {

    public final static String TYPE = "fragment";

    private RevenueWithdrawalState withdrawal_state;

    public TransactionPartnerFragment() {
        super(TYPE);
    }

    public RevenueWithdrawalState withdrawalState() {
        return withdrawal_state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionPartnerFragment that = (TransactionPartnerFragment) o;
        return Objects.equals(type(), that.type()) &&
                Objects.equals(withdrawal_state, that.withdrawal_state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type(), withdrawal_state);
    }

    @Override
    public String toString() {
        return "TransactionPartnerFragment{" +
                "type='" + type() + "\'," +
                ", withdrawal_state=" + withdrawal_state + "\'" +
                '}';
    }

}
