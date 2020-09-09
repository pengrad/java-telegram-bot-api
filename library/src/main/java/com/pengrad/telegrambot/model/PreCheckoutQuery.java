package com.pengrad.telegrambot.model;

import java.io.Serializable;
import java.util.Objects;

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

        if (!Objects.equals(id, that.id)) return false;
        if (!Objects.equals(from, that.from)) return false;
        if (!Objects.equals(currency, that.currency)) return false;
        if (!Objects.equals(total_amount, that.total_amount)) return false;
        if (!Objects.equals(invoice_payload, that.invoice_payload))
            return false;
        if (!Objects.equals(shipping_option_id, that.shipping_option_id))
            return false;
        return Objects.equals(order_info, that.order_info);
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
