package com.pengrad.telegrambot.passport;

import java.io.Serializable;

/**
 * Stas Parshin
 * 30 July 2018
 */
public class PassportElementErrorDataField extends PassportElementError implements Serializable {
    private final static long serialVersionUID = 0L;

    private final String field_name;
    private final String data_hash;

    public PassportElementErrorDataField(String type, String fieldName, String dataHash, String message) {
        super("data", type, message);
        field_name = fieldName;
        data_hash = dataHash;
    }
}
