package com.pengrad.telegrambot.passport;

import java.io.Serializable;

/**
 * Stas Parshin
 * 31 July 2018
 */
public class Credentials implements Serializable {
    private final static long serialVersionUID = 0L;

    private SecureData secure_data;
    private String nonce;

    public SecureData secureData() {
        return secure_data;
    }

    public String nonce() {
        return nonce;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Credentials that = (Credentials) o;

        if (secure_data != null ? !secure_data.equals(that.secure_data) : that.secure_data != null) return false;
        return nonce != null ? nonce.equals(that.nonce) : that.nonce == null;
    }

    @Override
    public int hashCode() {
        int result = secure_data != null ? secure_data.hashCode() : 0;
        result = 31 * result + (nonce != null ? nonce.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Credentials{" +
                "secure_data=" + secure_data +
                ", nonce='" + nonce + '\'' +
                '}';
    }
}
