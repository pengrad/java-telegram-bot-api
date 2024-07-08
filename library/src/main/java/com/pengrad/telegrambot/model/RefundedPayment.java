package com.pengrad.telegrambot.model;

import com.pengrad.telegrambot.model.stars.StarTransaction;

import java.io.Serializable;
import java.util.Objects;

public class RefundedPayment implements Serializable  {

    private final static long serialVersionUID = 0L;

    private String currency;

    private Integer total_amount;

    private String invoice_payload;

    private String telegram_payment_charge_id;

    private String provider_payment_charge_id;

    public String currency() {
        return currency;
    }

    public Integer totalAmount() {
        return total_amount;
    }

    public String invoicePayload() {
        return invoice_payload;
    }

    public String telegramPaymentChargeId() {
        return telegram_payment_charge_id;
    }

    public String providerPaymentChargeId() {
        return provider_payment_charge_id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RefundedPayment that = (RefundedPayment) o;
        return Objects.equals(currency, that.currency) &&
                Objects.equals(total_amount, that.total_amount) &&
                Objects.equals(invoice_payload, that.invoice_payload) &&
                Objects.equals(telegram_payment_charge_id, that.telegram_payment_charge_id) &&
                Objects.equals(provider_payment_charge_id, that.provider_payment_charge_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currency, total_amount, invoice_payload, telegram_payment_charge_id, provider_payment_charge_id);
    }

    @Override
    public String toString() {
        return "RefundedPayment{" +
                "currency='" + currency + "'," +
                "total_amount='" + total_amount + "'," +
                "invoice_payload='" + invoice_payload + "'," +
                "telegram_payment_charge_id='" + telegram_payment_charge_id + "'," +
                "provider_payment_charge_id='" + provider_payment_charge_id + "'" +
                '}';
    }


}
