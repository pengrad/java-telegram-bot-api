package com.pengrad.telegrambot.model;

import java.io.Serializable;

/**
 * stas
 * 5/3/16.
 */
public class MessageEntity implements Serializable {
    private final static long serialVersionUID = 0L;

    public enum Type {
        mention, hashtag, cashtag, bot_command, url, email, phone_number, bold, italic, code, pre, text_link,
        text_mention, underline, strikethrough
    }

    private Type type;
    private Integer offset;
    private Integer length;
    private String url;
    private User user;
    private String language;

    public Type type() {
        return type;
    }

    public Integer offset() {
        return offset;
    }

    public Integer length() {
        return length;
    }

    public String url() {
        return url;
    }

    public User user() {
        return user;
    }

    public String language() {
        return language;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MessageEntity that = (MessageEntity) o;

        if (type != that.type) return false;
        if (offset != null ? !offset.equals(that.offset) : that.offset != null) return false;
        if (length != null ? !length.equals(that.length) : that.length != null) return false;
        if (url != null ? !url.equals(that.url) : that.url != null) return false;
        if (user != null ? !user.equals(that.user) : that.user != null) return false;
        return language != null ? language.equals(that.language) : that.language == null;
    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + (offset != null ? offset.hashCode() : 0);
        result = 31 * result + (length != null ? length.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (language != null ? language.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "MessageEntity{" +
                "type=" + type +
                ", offset=" + offset +
                ", length=" + length +
                ", url='" + url + '\'' +
                ", user=" + user +
                ", language='" + language + '\'' +
                '}';
    }
}
