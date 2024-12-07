package com.pengrad.telegrambot.model;

import java.io.Serializable;

/**
 * Stas Parshin
 * 24 May 2017
 */
public class SuccessfulPayment implements Serializable {
    private final static long serialVersionUID = 0L;

    private String currency;
    private Integer total_amount;
    private String invoice_payload;
    private String shipping_option_id;
    private OrderInfo order_info;
    private String telegram_payment_charge_id;
    private String provider_payment_charge_id;
    private Integer subscription_expiration_date;
    private Boolean is_recurring;
    private Boolean is_first_recurring;

    public String currency() {
        return currency;
    }

    public Integer totalAmount() {
        return total_amount;
    }

    public String invoicePayload() {
        return invoice_payload;
    }

    public String shippingOptionId() {
        return shipping_option_id;
    }

    public OrderInfo orderInfo() {
        return order_info;
    }

    public String telegramPaymentChargeId() {
        return telegram_payment_charge_id;
    }

    public Integer subscriptionExpirationDate() {
        return subscription_expiration_date;
    }

    public Boolean isRecurring() {
        return is_recurring;
    }

    public Boolean isFirstRecurring() {
        return is_first_recurring;
    }

    public String providerPaymentChargeId() {
        return provider_payment_charge_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SuccessfulPayment that = (SuccessfulPayment) o;

        if (currency != null ? !currency.equals(that.currency) : that.currency != null) return false;
        if (total_amount != null ? !total_amount.equals(that.total_amount) : that.total_amount != null) return false;
        if (invoice_payload != null ? !invoice_payload.equals(that.invoice_payload) : that.invoice_payload != null)
            return false;
        if (shipping_option_id != null ? !shipping_option_id.equals(that.shipping_option_id) : that.shipping_option_id != null)
            return false;
        if (order_info != null ? !order_info.equals(that.order_info) : that.order_info != null) return false;
        if (telegram_payment_charge_id != null ? !telegram_payment_charge_id.equals(that.telegram_payment_charge_id) : that.telegram_payment_charge_id != null)
            return false;
        if (subscription_expiration_date != null ? !subscription_expiration_date.equals(that.subscription_expiration_date) : that.subscription_expiration_date != null)
            return false;
        if (is_recurring != null ? !is_recurring.equals(that.is_recurring) : that.is_recurring != null)
            return false;
        if (is_first_recurring != null ? !is_first_recurring.equals(that.is_first_recurring) : that.is_first_recurring != null)
            return false;

        return provider_payment_charge_id != null ? provider_payment_charge_id.equals(that.provider_payment_charge_id) : that.provider_payment_charge_id == null;

    }

    @Override
    public int hashCode() {
        int result = currency != null ? currency.hashCode() : 0;
        result = 31 * result + (total_amount != null ? total_amount.hashCode() : 0);
        result = 31 * result + (invoice_payload != null ? invoice_payload.hashCode() : 0);
        result = 31 * result + (shipping_option_id != null ? shipping_option_id.hashCode() : 0);
        result = 31 * result + (order_info != null ? order_info.hashCode() : 0);
        result = 31 * result + (telegram_payment_charge_id != null ? telegram_payment_charge_id.hashCode() : 0);
        result = 31 * result + (provider_payment_charge_id != null ? provider_payment_charge_id.hashCode() : 0);
        result = 31 * result + (subscription_expiration_date != null ? subscription_expiration_date.hashCode() : 0);
        result = 31 * result + (is_recurring != null ? is_recurring.hashCode() : 0);
        result = 31 * result + (is_first_recurring != null ? is_first_recurring.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "SuccessfulPayment{" +
                "currency='" + currency + '\'' +
                ", total_amount=" + total_amount +
                ", invoice_payload='" + invoice_payload + '\'' +
                ", shipping_option_id='" + shipping_option_id + '\'' +
                ", order_info=" + order_info +
                ", telegram_payment_charge_id='" + telegram_payment_charge_id + '\'' +
                ", provider_payment_charge_id='" + provider_payment_charge_id + '\'' +
                ", subscription_expiration_date='" + subscription_expiration_date + '\'' +
                ", is_recurring='" + is_recurring + '\'' +
                ", is_first_recurring='" + is_first_recurring + '\'' +
                '}';
    }
}
