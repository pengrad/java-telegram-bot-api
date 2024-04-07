package com.pengrad.telegrambot.model;

import java.io.Serializable;
import java.util.Objects;

public class Birthdate implements Serializable {

    private static final long serialVersionUID = 0L;

    private Integer day;
    private Integer month;
    private Integer year;

    public Integer day() {
        return day;
    }

    public Integer month() {
        return month;
    }

    public Integer year() {
        return year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Birthdate birthdate = (Birthdate) o;
        return Objects.equals(day, birthdate.day) && Objects.equals(month, birthdate.month) && Objects.equals(year, birthdate.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(day, month, year);
    }

    @Override
    public String toString() {
        return "Birthday{" +
                "day=" + day +
                ", month=" + month +
                ", year=" + year +
                '}';
    }
}
