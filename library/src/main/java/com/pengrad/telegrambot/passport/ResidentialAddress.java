package com.pengrad.telegrambot.passport;

import java.io.Serializable;

/**
 * Stas Parshin
 * 02 August 2018
 */
public class ResidentialAddress extends DecryptedData implements Serializable {
    private final static long serialVersionUID = 0L;

    private String street_line1;
    private String street_line2;
    private String city;
    private String state;
    private String country_code;
    private String post_code;

    public String streetLine1() {
        return street_line1;
    }

    public String streetLine2() {
        return street_line2;
    }

    public String city() {
        return city;
    }

    public String state() {
        return state;
    }

    public String countryCode() {
        return country_code;
    }

    public String postCode() {
        return post_code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ResidentialAddress that = (ResidentialAddress) o;

        if (street_line1 != null ? !street_line1.equals(that.street_line1) : that.street_line1 != null) return false;
        if (street_line2 != null ? !street_line2.equals(that.street_line2) : that.street_line2 != null) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (state != null ? !state.equals(that.state) : that.state != null) return false;
        if (country_code != null ? !country_code.equals(that.country_code) : that.country_code != null) return false;
        return post_code != null ? post_code.equals(that.post_code) : that.post_code == null;
    }

    @Override
    public int hashCode() {
        int result = street_line1 != null ? street_line1.hashCode() : 0;
        result = 31 * result + (street_line2 != null ? street_line2.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (country_code != null ? country_code.hashCode() : 0);
        result = 31 * result + (post_code != null ? post_code.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ResidentialAddress{" +
                "street_line1='" + street_line1 + '\'' +
                ", street_line2='" + street_line2 + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country_code='" + country_code + '\'' +
                ", post_code='" + post_code + '\'' +
                '}';
    }
}
