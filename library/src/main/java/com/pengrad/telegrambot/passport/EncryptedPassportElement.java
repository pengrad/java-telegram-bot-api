package com.pengrad.telegrambot.passport;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Stas Parshin
 * 30 July 2018
 */
public class EncryptedPassportElement implements Serializable {
    private final static long serialVersionUID = 0L;

    public enum Type {
        personal_details, passport, driver_license, identity_card, internal_passport, address, utility_bill,
        bank_statement, rental_agreement, passport_registration, temporary_registration, phone_number, email
    }

    private Type type;
    private String data;
    private String phone_number;
    private String email;
    private PassportFile[] files;
    private PassportFile front_side;
    private PassportFile reverse_side;
    private PassportFile selfie;

    public Type type() {
        return type;
    }

    public String data() {
        return data;
    }

    public String phoneNumber() {
        return phone_number;
    }

    public String email() {
        return email;
    }

    public PassportFile[] files() {
        return files;
    }

    public PassportFile frontSide() {
        return front_side;
    }

    public PassportFile reverseSide() {
        return reverse_side;
    }

    public PassportFile selfie() {
        return selfie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EncryptedPassportElement that = (EncryptedPassportElement) o;

        if (type != that.type) return false;
        if (data != null ? !data.equals(that.data) : that.data != null) return false;
        if (phone_number != null ? !phone_number.equals(that.phone_number) : that.phone_number != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(files, that.files)) return false;
        if (front_side != null ? !front_side.equals(that.front_side) : that.front_side != null) return false;
        if (reverse_side != null ? !reverse_side.equals(that.reverse_side) : that.reverse_side != null) return false;
        return selfie != null ? selfie.equals(that.selfie) : that.selfie == null;
    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + (data != null ? data.hashCode() : 0);
        result = 31 * result + (phone_number != null ? phone_number.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(files);
        result = 31 * result + (front_side != null ? front_side.hashCode() : 0);
        result = 31 * result + (reverse_side != null ? reverse_side.hashCode() : 0);
        result = 31 * result + (selfie != null ? selfie.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "EncryptedPassportElement{" +
                "type=" + type +
                ", data='" + data + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", email='" + email + '\'' +
                ", files=" + Arrays.toString(files) +
                ", front_side=" + front_side +
                ", reverse_side=" + reverse_side +
                ", selfie=" + selfie +
                '}';
    }
}
