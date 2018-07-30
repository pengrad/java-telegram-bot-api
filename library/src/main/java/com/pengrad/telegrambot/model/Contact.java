package com.pengrad.telegrambot.model;

import java.io.Serializable;

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

        if (phone_number != null ? !phone_number.equals(contact.phone_number) : contact.phone_number != null) return false;
        if (first_name != null ? !first_name.equals(contact.first_name) : contact.first_name != null) return false;
        if (last_name != null ? !last_name.equals(contact.last_name) : contact.last_name != null) return false;
        if (user_id != null ? !user_id.equals(contact.user_id) : contact.user_id != null) return false;
        return vcard != null ? vcard.equals(contact.vcard) : contact.vcard == null;
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
