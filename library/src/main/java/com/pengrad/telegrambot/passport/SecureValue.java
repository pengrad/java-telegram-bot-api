package com.pengrad.telegrambot.passport;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Stas Parshin
 * 31 July 2018
 */
public class SecureValue implements Serializable {
    private final static long serialVersionUID = 0L;

    private DataCredentials data;
    private FileCredentials front_side;
    private FileCredentials reverse_side;
    private FileCredentials selfie;
    private FileCredentials[] translation;
    private FileCredentials[] files;

    public DataCredentials data() {
        return data;
    }

    public FileCredentials frontSide() {
        return front_side;
    }

    public FileCredentials reverseSide() {
        return reverse_side;
    }

    public FileCredentials selfie() {
        return selfie;
    }

    public FileCredentials[] translation() {
        return translation;
    }

    public FileCredentials[] files() {
        return files;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SecureValue that = (SecureValue) o;

        if (data != null ? !data.equals(that.data) : that.data != null) return false;
        if (front_side != null ? !front_side.equals(that.front_side) : that.front_side != null) return false;
        if (reverse_side != null ? !reverse_side.equals(that.reverse_side) : that.reverse_side != null) return false;
        if (selfie != null ? !selfie.equals(that.selfie) : that.selfie != null) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(translation, that.translation)) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(files, that.files);
    }

    @Override
    public int hashCode() {
        int result = data != null ? data.hashCode() : 0;
        result = 31 * result + (front_side != null ? front_side.hashCode() : 0);
        result = 31 * result + (reverse_side != null ? reverse_side.hashCode() : 0);
        result = 31 * result + (selfie != null ? selfie.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(translation);
        result = 31 * result + Arrays.hashCode(files);
        return result;
    }

    @Override
    public String toString() {
        return "SecureValue{" +
                "data=" + data +
                ", front_side=" + front_side +
                ", reverse_side=" + reverse_side +
                ", selfie=" + selfie +
                ", translation=" + Arrays.toString(translation) +
                ", files=" + Arrays.toString(files) +
                '}';
    }
}
