package com.pengrad.telegrambot.passport;

import java.io.Serializable;

/**
 * Stas Parshin
 * 31 July 2018
 */
public class DataCredentials implements Serializable {
    private final static long serialVersionUID = 0L;

    private String data_hash;
    private String secret;

    public String dataHash() {
        return data_hash;
    }

    public String secret() {
        return secret;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DataCredentials that = (DataCredentials) o;

        if (data_hash != null ? !data_hash.equals(that.data_hash) : that.data_hash != null) return false;
        return secret != null ? secret.equals(that.secret) : that.secret == null;
    }

    @Override
    public int hashCode() {
        int result = data_hash != null ? data_hash.hashCode() : 0;
        result = 31 * result + (secret != null ? secret.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "DataCredentials{" +
                "data_hash='" + data_hash + '\'' +
                ", secret='" + secret + '\'' +
                '}';
    }
}
