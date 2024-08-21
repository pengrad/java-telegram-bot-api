package com.pengrad.telegrambot.model.business;

import java.util.Objects;

public class BusinessOpeningHoursInterval {

    private Integer opening_minute;
    private Integer closing_minute;

    public Integer opening_minute() {
        return opening_minute;
    }

    public Integer closing_minute() {
        return closing_minute;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BusinessOpeningHoursInterval that = (BusinessOpeningHoursInterval) o;
        return Objects.equals(opening_minute, that.opening_minute) && Objects.equals(closing_minute, that.closing_minute);
    }

    @Override
    public int hashCode() {
        return Objects.hash(opening_minute, closing_minute);
    }

    @Override
    public String toString() {
        return "BusinessOpeningHoursInterval{" +
                "opening_minute=" + opening_minute +
                ", closing_minute=" + closing_minute +
                '}';
    }
}
