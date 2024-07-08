package com.pengrad.telegrambot.model.stars.partner;

import com.pengrad.telegrambot.model.User;
import com.pengrad.telegrambot.model.chatbackground.BackgroundFillFreeformGradient;

import java.util.Arrays;
import java.util.Objects;

public class TransactionPartnerUser extends TransactionPartner {

    public final static String TYPE = "user";

    private User user;
    private String invoice_payload;

    public TransactionPartnerUser() {
        super(TYPE);
    }

    public User user() {
        return user;
    }

    public String invoicePayload() {
        return invoice_payload;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionPartnerUser that = (TransactionPartnerUser) o;
        return Objects.equals(type(), that.type()) &&
                Objects.equals(user, that.user) &&
                Objects.equals(invoice_payload, that.invoice_payload);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type(), user, invoice_payload);
    }

    @Override
    public String toString() {
        return "TransactionPartnerUser{" +
                "type='" + type() + "\'," +
                ", user=" + user + "\'," +
                ", invoice_payload=" + invoice_payload + "\'" +
                '}';
    }

}
