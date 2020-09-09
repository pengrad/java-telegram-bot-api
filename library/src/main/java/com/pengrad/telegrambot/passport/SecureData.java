package com.pengrad.telegrambot.passport;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Objects;

/**
 * Stas Parshin
 * 31 July 2018
 */
public class SecureData implements Serializable {
    private final static long serialVersionUID = 0L;

    private SecureValue
            personal_details,
            passport,
            internal_passport,
            driver_license,
            identity_card,
            address,
            utility_bill,
            bank_statement,
            rental_agreement,
            passport_registration,
            temporary_registration;

    public SecureValue ofType(EncryptedPassportElement.Type type) {
        try {
            Field field = getClass().getDeclaredField(type.name());
            return (SecureValue) field.get(this);
        } catch (Exception e) {
            return null;
        }
    }

    public SecureValue personalDetails() {
        return personal_details;
    }

    public SecureValue passport() {
        return passport;
    }

    public SecureValue internalPassport() {
        return internal_passport;
    }

    public SecureValue driverLicense() {
        return driver_license;
    }

    public SecureValue identityCard() {
        return identity_card;
    }

    public SecureValue address() {
        return address;
    }

    public SecureValue utilityBill() {
        return utility_bill;
    }

    public SecureValue bankStatement() {
        return bank_statement;
    }

    public SecureValue rentalAgreement() {
        return rental_agreement;
    }

    public SecureValue passportRegistration() {
        return passport_registration;
    }

    public SecureValue temporaryRegistration() {
        return temporary_registration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SecureData that = (SecureData) o;

        if (!Objects.equals(personal_details, that.personal_details))
            return false;
        if (!Objects.equals(passport, that.passport)) return false;
        if (!Objects.equals(internal_passport, that.internal_passport))
            return false;
        if (!Objects.equals(driver_license, that.driver_license)) return false;
        if (!Objects.equals(identity_card, that.identity_card)) return false;
        if (!Objects.equals(address, that.address)) return false;
        if (!Objects.equals(utility_bill, that.utility_bill)) return false;
        if (!Objects.equals(bank_statement, that.bank_statement)) return false;
        if (!Objects.equals(rental_agreement, that.rental_agreement))
            return false;
        if (!Objects.equals(passport_registration, that.passport_registration))
            return false;
        return Objects.equals(temporary_registration, that.temporary_registration);
    }

    @Override
    public int hashCode() {
        int result = personal_details != null ? personal_details.hashCode() : 0;
        result = 31 * result + (passport != null ? passport.hashCode() : 0);
        result = 31 * result + (internal_passport != null ? internal_passport.hashCode() : 0);
        result = 31 * result + (driver_license != null ? driver_license.hashCode() : 0);
        result = 31 * result + (identity_card != null ? identity_card.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (utility_bill != null ? utility_bill.hashCode() : 0);
        result = 31 * result + (bank_statement != null ? bank_statement.hashCode() : 0);
        result = 31 * result + (rental_agreement != null ? rental_agreement.hashCode() : 0);
        result = 31 * result + (passport_registration != null ? passport_registration.hashCode() : 0);
        result = 31 * result + (temporary_registration != null ? temporary_registration.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "SecureData{" +
                "personal_details=" + personal_details +
                ", passport=" + passport +
                ", internal_passport=" + internal_passport +
                ", driver_license=" + driver_license +
                ", identity_card=" + identity_card +
                ", address=" + address +
                ", utility_bill=" + utility_bill +
                ", bank_statement=" + bank_statement +
                ", rental_agreement=" + rental_agreement +
                ", passport_registration=" + passport_registration +
                ", temporary_registration=" + temporary_registration +
                '}';
    }
}
