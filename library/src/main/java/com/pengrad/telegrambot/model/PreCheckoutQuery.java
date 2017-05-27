package com.pengrad.telegrambot.model;

import java.io.Serializable;

/**
 * Stas Parshin
 * 24 May 2017
 */
public class PreCheckoutQuery implements Serializable {
    private final static long serialVersionUID = 0L;

    private String id;
    private User from;
    private String currency;
    private Integer total_amount;
    private String invoice_payload;
    private String shipping_option_id;
    private OrderInfo order_info;

    public String id() {
        return id;
    }

    public User from() {
        return from;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PreCheckoutQuery that = (PreCheckoutQuery) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (from != null ? !from.equals(that.from) : that.from != null) return false;
        if (currency != null ? !currency.equals(that.currency) : that.currency != null) return false;
        if (total_amount != null ? !total_amount.equals(that.total_amount) : that.total_amount != null) return false;
        if (invoice_payload != null ? !invoice_payload.equals(that.invoice_payload) : that.invoice_payload != null)
            return false;
        if (shipping_option_id != null ? !shipping_option_id.equals(that.shipping_option_id) : that.shipping_option_id != null)
            return false;
        return order_info != null ? order_info.equals(that.order_info) : that.order_info == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "PreCheckoutQuery{" +
                "id='" + id + '\'' +
                ", from=" + from +
                ", currency='" + currency + '\'' +
                ", total_amount=" + total_amount +
                ", invoice_payload='" + invoice_payload + '\'' +
                ", shipping_option_id='" + shipping_option_id + '\'' +
                ", order_info=" + order_info +
                '}';
    }
}
