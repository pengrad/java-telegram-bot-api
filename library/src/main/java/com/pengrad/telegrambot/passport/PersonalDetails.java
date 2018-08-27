package com.pengrad.telegrambot.passport;

import java.io.Serializable;

/**
 * Stas Parshin
 * 02 August 2018
 */
public class PersonalDetails extends DecryptedData implements Serializable {
    private final static long serialVersionUID = 0L;

    private String first_name;
    private String last_name;
    private String middle_name;
    private String birth_date;
    private String gender;
    private String country_code;
    private String residence_country_code;
    private String first_name_native;
    private String last_name_native;
    private String middle_name_native;

    public String firstName() {
        return first_name;
    }

    public String lastName() {
        return last_name;
    }

    public String middleName() {
        return middle_name;
    }

    public String birthDate() {
        return birth_date;
    }

    public String gender() {
        return gender;
    }

    public String countryCode() {
        return country_code;
    }

    public String residenceCountryCode() {
        return residence_country_code;
    }

    public String firstNameNative() {
        return first_name_native;
    }

    public String lastNameNative() {
        return last_name_native;
    }

    public String middleNameNative() {
        return middle_name_native;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonalDetails that = (PersonalDetails) o;

        if (first_name != null ? !first_name.equals(that.first_name) : that.first_name != null) return false;
        if (last_name != null ? !last_name.equals(that.last_name) : that.last_name != null) return false;
        if (middle_name != null ? !middle_name.equals(that.middle_name) : that.middle_name != null) return false;
        if (birth_date != null ? !birth_date.equals(that.birth_date) : that.birth_date != null) return false;
        if (gender != null ? !gender.equals(that.gender) : that.gender != null) return false;
        if (country_code != null ? !country_code.equals(that.country_code) : that.country_code != null) return false;
        if (residence_country_code != null ? !residence_country_code.equals(that.residence_country_code) : that.residence_country_code != null)
            return false;
        if (first_name_native != null ? !first_name_native.equals(that.first_name_native) : that.first_name_native != null)
            return false;
        if (last_name_native != null ? !last_name_native.equals(that.last_name_native) : that.last_name_native != null)
            return false;
        return middle_name_native != null ? middle_name_native.equals(that.middle_name_native) : that.middle_name_native == null;
    }

    @Override
    public int hashCode() {
        int result = first_name != null ? first_name.hashCode() : 0;
        result = 31 * result + (last_name != null ? last_name.hashCode() : 0);
        result = 31 * result + (middle_name != null ? middle_name.hashCode() : 0);
        result = 31 * result + (birth_date != null ? birth_date.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (country_code != null ? country_code.hashCode() : 0);
        result = 31 * result + (residence_country_code != null ? residence_country_code.hashCode() : 0);
        result = 31 * result + (first_name_native != null ? first_name_native.hashCode() : 0);
        result = 31 * result + (last_name_native != null ? last_name_native.hashCode() : 0);
        result = 31 * result + (middle_name_native != null ? middle_name_native.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PersonalDetails{" +
                "first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", middle_name='" + middle_name + '\'' +
                ", birth_date='" + birth_date + '\'' +
                ", gender='" + gender + '\'' +
                ", country_code='" + country_code + '\'' +
                ", residence_country_code='" + residence_country_code + '\'' +
                ", first_name_native='" + first_name_native + '\'' +
                ", last_name_native='" + last_name_native + '\'' +
                ", middle_name_native='" + middle_name_native + '\'' +
                '}';
    }
}
