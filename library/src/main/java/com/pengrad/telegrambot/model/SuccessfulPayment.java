package com.pengrad.telegrambot.model;

import java.io.Serializable;
import java.util.Objects;

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

    public String providerPaymentChargeId() {
        return provider_payment_charge_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SuccessfulPayment that = (SuccessfulPayment) o;

        if (!Objects.equals(currency, that.currency)) return false;
        if (!Objects.equals(total_amount, that.total_amount)) return false;
        if (!Objects.equals(invoice_payload, that.invoice_payload))
            return false;
        if (!Objects.equals(shipping_option_id, that.shipping_option_id))
            return false;
        if (!Objects.equals(order_info, that.order_info)) return false;
        if (!Objects.equals(telegram_payment_charge_id, that.telegram_payment_charge_id))
            return false;
        return Objects.equals(provider_payment_charge_id, that.provider_payment_charge_id);

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
                '}';
    }
}
