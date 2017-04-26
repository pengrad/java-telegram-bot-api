package com.pengrad.telegrambot.model;

import java.io.Serializable;

/**
 * Stas Parshin
 * 03 October 2016
 */
public class ResponseParameters implements Serializable {
    private final static long serialVersionUID = 0L;

    private Long migrate_to_chat_id;
    private Integer retry_after;

    public Long migrateToChatId() {
        return migrate_to_chat_id;
    }

    public Integer retryAfter() {
        return retry_after;
    }

    @Override
    public String toString() {
        return "ResponseParameters{" +
                "migrate_to_chat_id=" + migrate_to_chat_id +
                ", retry_after=" + retry_after +
                '}';
    }
}
