package com.pengrad.telegrambot.model;

/**
 * Stas Parshin
 * 03 October 2016
 */
public class ResponseParameters {

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
