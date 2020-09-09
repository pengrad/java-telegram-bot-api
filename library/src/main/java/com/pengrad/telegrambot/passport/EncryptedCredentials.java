package com.pengrad.telegrambot.passport;

import com.pengrad.telegrambot.passport.decrypt.Decrypt;

import java.io.Serializable;
import java.util.Objects;

/**
 * Stas Parshin
 * 30 July 2018
 */
public class EncryptedCredentials implements Serializable {
    private final static long serialVersionUID = 0L;

    private String data;
    private String hash;
    private String secret;

    public Credentials decrypt(String privateKey) throws Exception {
        return Decrypt.decryptCredentials(privateKey, data, hash, secret);
    }

    public String data() {
        return data;
    }

    public String hash() {
        return hash;
    }

    public String secret() {
        return secret;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EncryptedCredentials that = (EncryptedCredentials) o;

        if (!Objects.equals(data, that.data)) return false;
        if (!Objects.equals(hash, that.hash)) return false;
        return Objects.equals(secret, that.secret);
    }

    @Override
    public int hashCode() {
        int result = data != null ? data.hashCode() : 0;
        result = 31 * result + (hash != null ? hash.hashCode() : 0);
        result = 31 * result + (secret != null ? secret.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "EncryptedCredentials{" +
                "data='" + data + '\'' +
                ", hash='" + hash + '\'' +
                ", secret='" + secret + '\'' +
                '}';
    }
}
