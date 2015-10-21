package com.pengrad.telegrambot.model;

/**
 * stas
 * 8/5/15.
 */
public class Contact {

    private final String phone_number;
    private final String first_name;
    private final String last_name;
    private final Integer user_id;

    public Contact(String phone_number, String first_name, String last_name, Integer user_id) {
        this.phone_number = phone_number;
        this.first_name = first_name;
        this.last_name = last_name;
        this.user_id = user_id;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contact contact = (Contact) o;

        if (!phone_number.equals(contact.phone_number)) return false;
        if (!first_name.equals(contact.first_name)) return false;
        if (last_name != null ? !last_name.equals(contact.last_name) : contact.last_name != null) return false;
        return !(user_id != null ? !user_id.equals(contact.user_id) : contact.user_id != null);

    }

    @Override
    public int hashCode() {
        return phone_number.hashCode();
    }

    @Override
    public String toString() {
        return "Contact{" +
                "phone_number='" + phone_number + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", user_id=" + user_id +
                '}';
    }
}
