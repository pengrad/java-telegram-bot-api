package com.pengrad.telegrambot.model.stars;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

public class StarTransactions implements Serializable {

    private final static long serialVersionUID = 0L;

    private StarTransaction[] transactions;

    public StarTransaction[] transactions() {
        return transactions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StarTransactions that = (StarTransactions) o;
        return Arrays.equals(transactions, that.transactions);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(transactions);
    }

    @Override
    public String toString() {
        return "StarTransactions{" +
                "transactions='" + Arrays.toString(transactions) + "'" +
                '}';
    }

}
