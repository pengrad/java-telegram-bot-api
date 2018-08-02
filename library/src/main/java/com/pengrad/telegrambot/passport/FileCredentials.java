package com.pengrad.telegrambot.passport;

import java.io.Serializable;

/**
 * Stas Parshin
 * 31 July 2018
 */
public class FileCredentials implements Serializable {
    private final static long serialVersionUID = 0L;

    private String file_hash;
    private String secret;

    public String fileHash() {
        return file_hash;
    }

    public String secret() {
        return secret;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FileCredentials that = (FileCredentials) o;

        if (file_hash != null ? !file_hash.equals(that.file_hash) : that.file_hash != null) return false;
        return secret != null ? secret.equals(that.secret) : that.secret == null;
    }

    @Override
    public int hashCode() {
        int result = file_hash != null ? file_hash.hashCode() : 0;
        result = 31 * result + (secret != null ? secret.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "FileCredentials{" +
                "file_hash='" + file_hash + '\'' +
                ", secret='" + secret + '\'' +
                '}';
    }
}
