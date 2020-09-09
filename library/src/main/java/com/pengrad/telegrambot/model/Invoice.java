package com.pengrad.telegrambot.model;

import java.io.Serializable;
import java.util.Objects;

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

        if (!Objects.equals(title, invoice.title)) return false;
        if (!Objects.equals(description, invoice.description)) return false;
        if (!Objects.equals(start_parameter, invoice.start_parameter))
            return false;
        if (!Objects.equals(currency, invoice.currency)) return false;
        return Objects.equals(total_amount, invoice.total_amount);
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
