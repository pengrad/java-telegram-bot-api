package com.pengrad.telegrambot.model.request;

import java.io.Serializable;

/**
 * Stas Parshin
 * 06 May 2016
 */
public class InlineQueryResultContact extends InlineQueryResult<InlineQueryResultContact> implements Serializable {
    private final static long serialVersionUID = 0L;

    private String phone_number;
    private String first_name;

    private String last_name;
    private String vcard;
    private String thumb_url;
    private Integer thumb_width;
    private Integer thumb_height;

    public InlineQueryResultContact(String id, String phoneNumber, String firstName) {
        super("contact", id);
        this.phone_number = phoneNumber;
        this.first_name = firstName;
    }

    public InlineQueryResultContact lastName(String lastName) {
        this.last_name = lastName;
        return this;
    }

    public InlineQueryResultContact vcard(String vcard) {
        this.vcard = vcard;
        return this;
    }

    public InlineQueryResultContact thumbUrl(String thumbUrl) {
        this.thumb_url = thumbUrl;
        return this;
    }

    public InlineQueryResultContact thumbWidth(Integer thumbWidth) {
        this.thumb_width = thumbWidth;
        return this;
    }

    public InlineQueryResultContact thumbHeight(Integer thumbHeight) {
        this.thumb_height = thumbHeight;
        return this;
    }
}
