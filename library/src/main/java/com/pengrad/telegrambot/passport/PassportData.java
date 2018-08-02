package com.pengrad.telegrambot.passport;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Stas Parshin
 * 30 July 2018
 */
public class PassportData implements Serializable {
    private final static long serialVersionUID = 0L;

    private EncryptedPassportElement[] data;
    private EncryptedCredentials credentials;

    public EncryptedPassportElement[] data() {
        return data;
    }

    public EncryptedCredentials credentials() {
        return credentials;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PassportData that = (PassportData) o;

        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(data, that.data)) return false;
        return credentials != null ? credentials.equals(that.credentials) : that.credentials == null;
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(data);
        result = 31 * result + (credentials != null ? credentials.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PassportData{" +
                "data=" + Arrays.toString(data) +
                ", credentials=" + credentials +
                '}';
    }
}
