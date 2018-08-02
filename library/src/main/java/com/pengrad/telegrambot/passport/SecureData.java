package com.pengrad.telegrambot.passport;

import java.io.Serializable;
import java.lang.reflect.Field;

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

        if (personal_details != null ? !personal_details.equals(that.personal_details) : that.personal_details != null)
            return false;
        if (passport != null ? !passport.equals(that.passport) : that.passport != null) return false;
        if (internal_passport != null ? !internal_passport.equals(that.internal_passport) : that.internal_passport != null)
            return false;
        if (driver_license != null ? !driver_license.equals(that.driver_license) : that.driver_license != null) return false;
        if (identity_card != null ? !identity_card.equals(that.identity_card) : that.identity_card != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (utility_bill != null ? !utility_bill.equals(that.utility_bill) : that.utility_bill != null) return false;
        if (bank_statement != null ? !bank_statement.equals(that.bank_statement) : that.bank_statement != null) return false;
        if (rental_agreement != null ? !rental_agreement.equals(that.rental_agreement) : that.rental_agreement != null)
            return false;
        if (passport_registration != null ? !passport_registration.equals(that.passport_registration) : that.passport_registration != null)
            return false;
        return temporary_registration != null ? temporary_registration.equals(that.temporary_registration) : that.temporary_registration == null;
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
