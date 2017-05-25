package com.pengrad.telegrambot.model;

import java.io.Serializable;

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

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (from != null ? !from.equals(that.from) : that.from != null) return false;
        if (invoice_payload != null ? !invoice_payload.equals(that.invoice_payload) : that.invoice_payload != null)
            return false;
        return shipping_address != null ? shipping_address.equals(that.shipping_address) : that.shipping_address == null;
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
