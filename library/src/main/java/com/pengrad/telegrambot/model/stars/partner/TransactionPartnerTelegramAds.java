package com.pengrad.telegrambot.model.stars.partner;

import java.util.Objects;

public class TransactionPartnerTelegramAds extends TransactionPartner {

    public final static String TYPE = "telegram_ads";

    public TransactionPartnerTelegramAds() {
        super(TYPE);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionPartnerTelegramAds that = (TransactionPartnerTelegramAds) o;
        return Objects.equals(type(), that.type());
    }

    @Override
    public int hashCode() {
        return Objects.hash(type());
    }

    @Override
    public String toString() {
        return "TransactionPartnerTelegramAds{" +
                "type='" + type() + "\'" +
                '}';
    }

}
