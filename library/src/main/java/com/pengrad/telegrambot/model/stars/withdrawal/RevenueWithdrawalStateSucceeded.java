package com.pengrad.telegrambot.model.stars.withdrawal;

import java.util.Objects;

public class RevenueWithdrawalStateSucceeded extends RevenueWithdrawalState {

    public static final String TYPE = "succeeded";

    private Integer date;
    private String url;

    public RevenueWithdrawalStateSucceeded() {
        super(TYPE);
    }

    public Integer date() {
        return date;
    }

    public String url() {
        return url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RevenueWithdrawalStateSucceeded that = (RevenueWithdrawalStateSucceeded) o;
        return Objects.equals(type(), that.type()) &&
                Objects.equals(date, that.date) &&
                Objects.equals(url, that.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type(), date, url);
    }

    @Override
    public String toString() {
        return "RevenueWithdrawalStateSucceeded{" +
                "date=" + date +
                ", url='" + url + '\'' +
                '}';
    }
}
