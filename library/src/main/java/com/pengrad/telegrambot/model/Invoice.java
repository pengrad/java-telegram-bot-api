package com.pengrad.telegrambot.model;

import java.io.Serializable;

/**
 * Stas Parshin
 * 24 May 2017
 */
public class Invoice implements Serializable {
    private final static long serialVersionUID = 0L;

    private String title, description, start_parameter, currency;
    private Integer total_amount;

    public String title() {
        return title;
    }

    public String description() {
        return description;
    }

    public String startParameter() {
        return start_parameter;
    }

    public String currency() {
        return currency;
    }

    public Integer totalAmount() {
        return total_amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Invoice invoice = (Invoice) o;

        if (title != null ? !title.equals(invoice.title) : invoice.title != null) return false;
        if (description != null ? !description.equals(invoice.description) : invoice.description != null) return false;
        if (start_parameter != null ? !start_parameter.equals(invoice.start_parameter) : invoice.start_parameter != null)
            return false;
        if (currency != null ? !currency.equals(invoice.currency) : invoice.currency != null) return false;
        return total_amount != null ? total_amount.equals(invoice.total_amount) : invoice.total_amount == null;
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (start_parameter != null ? start_parameter.hashCode() : 0);
        result = 31 * result + (currency != null ? currency.hashCode() : 0);
        result = 31 * result + (total_amount != null ? total_amount.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", start_parameter='" + start_parameter + '\'' +
                ", currency='" + currency + '\'' +
                ", total_amount=" + total_amount +
                '}';
    }
}
