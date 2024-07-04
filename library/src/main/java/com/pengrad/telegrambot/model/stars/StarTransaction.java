package com.pengrad.telegrambot.model.stars;

import com.pengrad.telegrambot.model.stars.partner.TransactionPartner;

import java.io.Serializable;
import java.util.Objects;

public class StarTransaction implements Serializable {

    private final static long serialVersionUID = 0L;

    private String id;
    private Integer amount;
    private Integer date;

    private TransactionPartner source;

    private TransactionPartner receiver;


    public String id() {
        return id;
    }

    public Integer amount() {
        return amount;
    }

    public Integer date() {
        return date;
    }

    public TransactionPartner source() {
        return source;
    }

    public TransactionPartner receiver() {
        return receiver;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StarTransaction that = (StarTransaction) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(amount, that.amount) &&
                Objects.equals(date, that.date) &&
                Objects.equals(source, that.source) &&
                Objects.equals(receiver, that.receiver);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount, date, source, receiver);
    }

    @Override
    public String toString() {
        return "StarTransaction{" +
                "id='" + id + "'," +
                "amount='" + amount + "'," +
                "date='" + date + "'," +
                "source='" + source + "'," +
                "receiver='" + receiver + "'" +
                '}';
    }

}
