package com.pengrad.telegrambot.passport;

import java.io.Serializable;

/**
 * Stas Parshin
 * 02 August 2018
 */
public class IdDocumentData extends DecryptedData implements Serializable {
    private final static long serialVersionUID = 0L;

    private String document_no;
    private String expiry_date;

    public String documentNo() {
        return document_no;
    }

    public String expiryDate() {
        return expiry_date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IdDocumentData that = (IdDocumentData) o;

        if (document_no != null ? !document_no.equals(that.document_no) : that.document_no != null) return false;
        return expiry_date != null ? expiry_date.equals(that.expiry_date) : that.expiry_date == null;
    }

    @Override
    public int hashCode() {
        int result = document_no != null ? document_no.hashCode() : 0;
        result = 31 * result + (expiry_date != null ? expiry_date.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "IdDocumentData{" +
                "document_no='" + document_no + '\'' +
                ", expiry_date='" + expiry_date + '\'' +
                '}';
    }
}
