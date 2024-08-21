package com.pengrad.telegrambot.model.business;

import java.util.Arrays;
import java.util.Objects;

public class BusinessOpeningHours {

    private String time_zone_name;
    private BusinessOpeningHoursInterval[] opening_hours;

    public String timeZoneName() {
        return time_zone_name;
    }

    public BusinessOpeningHoursInterval[] openingHours() {
        return opening_hours;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BusinessOpeningHours that = (BusinessOpeningHours) o;
        return Objects.equals(time_zone_name, that.time_zone_name) && Objects.deepEquals(opening_hours, that.opening_hours);
    }

    @Override
    public int hashCode() {
        return Objects.hash(time_zone_name, Arrays.hashCode(opening_hours));
    }

    @Override
    public String toString() {
        return "BusinessOpeningHours{" +
                "time_zone_name='" + time_zone_name + '\'' +
                ", opening_hours=" + Arrays.toString(opening_hours) +
                '}';
    }
}
