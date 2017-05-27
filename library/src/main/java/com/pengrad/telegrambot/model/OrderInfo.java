package com.pengrad.telegrambot.model;

import java.io.Serializable;

/**
 * Stas Parshin
 * 24 May 2017
 */
public class OrderInfo implements Serializable {
    private final static long serialVersionUID = 0L;

    private String name, phone_number, email;
    private ShippingAddress shipping_address;

    public String name() {
        return name;
    }

    public String phoneNumber() {
        return phone_number;
    }

    public String email() {
        return email;
    }

    public ShippingAddress shippingAddress() {
        return shipping_address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderInfo orderInfo = (OrderInfo) o;

        if (name != null ? !name.equals(orderInfo.name) : orderInfo.name != null) return false;
        if (phone_number != null ? !phone_number.equals(orderInfo.phone_number) : orderInfo.phone_number != null) return false;
        if (email != null ? !email.equals(orderInfo.email) : orderInfo.email != null) return false;
        return shipping_address != null ? shipping_address.equals(orderInfo.shipping_address) : orderInfo.shipping_address == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (phone_number != null ? phone_number.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (shipping_address != null ? shipping_address.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "OrderInfo{" +
                "name='" + name + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", email='" + email + '\'' +
                ", shipping_address=" + shipping_address +
                '}';
    }
}
