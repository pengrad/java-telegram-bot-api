package com.pengrad.telegrambot.model.business;

import com.pengrad.telegrambot.model.Location;

import java.util.Objects;

public class BusinessLocation {

    private String address;
    private Location location;

    public String address() {
        return address;
    }

    public Location location() {
        return location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BusinessLocation that = (BusinessLocation) o;
        return Objects.equals(address, that.address) && Objects.equals(location, that.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, location);
    }

    @Override
    public String toString() {
        return "BusinessLocation{" +
                "address='" + address + '\'' +
                ", location=" + location +
                '}';
    }
}
