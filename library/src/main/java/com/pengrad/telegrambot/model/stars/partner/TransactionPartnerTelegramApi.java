package com.pengrad.telegrambot.model.stars.partner;

import java.util.Objects;

public class TransactionPartnerTelegramApi extends TransactionPartner {

    public final static String TYPE = "telegram_api";

    private Integer request_count;

    public TransactionPartnerTelegramApi() {
        super(TYPE);
    }

    public Integer requestCount() {
        return request_count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TransactionPartnerTelegramApi)) return false;
        if (!super.equals(o)) return false;
        TransactionPartnerTelegramApi that = (TransactionPartnerTelegramApi) o;
        return Objects.equals(request_count, that.request_count);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), request_count);
    }

    @Override
    public String toString() {
        return "TransactionPartnerTelegramApi{" +
            "request_count=" + request_count +
            '}';
    }
}
