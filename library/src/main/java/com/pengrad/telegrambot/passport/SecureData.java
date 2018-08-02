package com.pengrad.telegrambot.passport;

import java.lang.reflect.Field;

/**
 * Stas Parshin
 * 31 July 2018
 */
public class SecureData {

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
