package com.pengrad.telegrambot.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * stas
 * 8/5/15.
 */
public class Contact implements Serializable {
    private final static long serialVersionUID = 0L;

    private String phone_number;
    private String first_name;
    private String last_name;
    private Integer user_id;
    private String vcard;

    public String phoneNumber() {
        return phone_number;
    }

    public String firstName() {
        return first_name;
    }

    public String lastName() {
        return last_name;
    }

    public Integer userId() {
        return user_id;
    }

    public String vcard() {
        return vcard;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contact contact = (Contact) o;

        if (!Objects.equals(phone_number, contact.phone_number)) return false;
        if (!Objects.equals(first_name, contact.first_name)) return false;
        if (!Objects.equals(last_name, contact.last_name)) return false;
        if (!Objects.equals(user_id, contact.user_id)) return false;
        return Objects.equals(vcard, contact.vcard);
    }

    @Override
    public int hashCode() {
        return phone_number != null ? phone_number.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "phone_number='" + phone_number + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", user_id=" + user_id +
                ", vcard='" + vcard + '\'' +
                '}';
    }
}
