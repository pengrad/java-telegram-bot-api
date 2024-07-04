package com.pengrad.telegrambot.model.stars.partner;

import java.util.Objects;

public class TransactionPartnerOther extends TransactionPartner {

    public final static String TYPE = "other";

    public TransactionPartnerOther() {
        super(TYPE);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionPartnerOther that = (TransactionPartnerOther) o;
        return Objects.equals(type(), that.type());
    }

    @Override
    public int hashCode() {
        return Objects.hash(type());
    }

    @Override
    public String toString() {
        return "TransactionPartnerOther{" +
                "type='" + type() + "\'" +
                '}';
    }

}
