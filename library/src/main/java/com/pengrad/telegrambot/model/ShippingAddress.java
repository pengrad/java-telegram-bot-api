package com.pengrad.telegrambot.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * Stas Parshin
 * 24 May 2017
 */
public class ShippingAddress implements Serializable {
    private final static long serialVersionUID = 0L;

    private String country_code, state, city, street_line1, street_line2, post_code;

    public String countryCode() {
        return country_code;
    }

    public String state() {
        return state;
    }

    public String city() {
        return city;
    }

    public String streetLine1() {
        return street_line1;
    }

    public String streetLine2() {
        return street_line2;
    }

    public String postCode() {
        return post_code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShippingAddress that = (ShippingAddress) o;

        if (!Objects.equals(country_code, that.country_code)) return false;
        if (!Objects.equals(state, that.state)) return false;
        if (!Objects.equals(city, that.city)) return false;
        if (!Objects.equals(street_line1, that.street_line1)) return false;
        if (!Objects.equals(street_line2, that.street_line2)) return false;
        return Objects.equals(post_code, that.post_code);

    }

    @Override
    public int hashCode() {
        int result = country_code != null ? country_code.hashCode() : 0;
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (street_line1 != null ? street_line1.hashCode() : 0);
        result = 31 * result + (street_line2 != null ? street_line2.hashCode() : 0);
        result = 31 * result + (post_code != null ? post_code.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ShippingAddress{" +
                "country_code='" + country_code + '\'' +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", street_line1='" + street_line1 + '\'' +
                ", street_line2='" + street_line2 + '\'' +
                ", post_code='" + post_code + '\'' +
                '}';
    }
}
