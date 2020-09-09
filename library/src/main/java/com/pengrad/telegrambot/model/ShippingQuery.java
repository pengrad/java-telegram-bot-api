package com.pengrad.telegrambot.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * Stas Parshin
 * 24 May 2017
 */
public class ShippingQuery implements Serializable {
    private final static long serialVersionUID = 0L;

    private String id;
    private User from;
    private String invoice_payload;
    private ShippingAddress shipping_address;

    public String id() {
        return id;
    }

    public User from() {
        return from;
    }

    public String invoicePayload() {
        return invoice_payload;
    }

    public ShippingAddress shippingAddress() {
        return shipping_address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShippingQuery that = (ShippingQuery) o;

        if (!Objects.equals(id, that.id)) return false;
        if (!Objects.equals(from, that.from)) return false;
        if (!Objects.equals(invoice_payload, that.invoice_payload))
            return false;
        return Objects.equals(shipping_address, that.shipping_address);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "ShippingQuery{" +
                "id='" + id + '\'' +
                ", from=" + from +
                ", invoice_payload='" + invoice_payload + '\'' +
                ", shipping_address=" + shipping_address +
                '}';
    }
}
