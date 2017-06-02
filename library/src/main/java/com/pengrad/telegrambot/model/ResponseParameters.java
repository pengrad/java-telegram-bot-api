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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ResponseParameters that = (ResponseParameters) o;

        if (migrate_to_chat_id != null ? !migrate_to_chat_id.equals(that.migrate_to_chat_id) : that.migrate_to_chat_id != null)
            return false;
        return retry_after != null ? retry_after.equals(that.retry_after) : that.retry_after == null;
    }

    @Override
    public int hashCode() {
        int result = migrate_to_chat_id != null ? migrate_to_chat_id.hashCode() : 0;
        result = 31 * result + (retry_after != null ? retry_after.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ResponseParameters{" +
                "migrate_to_chat_id=" + migrate_to_chat_id +
                ", retry_after=" + retry_after +
                '}';
    }
}
