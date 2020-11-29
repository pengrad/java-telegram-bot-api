package com.pengrad.telegrambot.model;

import java.io.Serializable;
import java.util.Objects;

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

    private MessageEntity() {
    }

    public MessageEntity(Type type, Integer offset, Integer length) {
        this.type = type;
        this.offset = offset;
        this.length = length;
    }

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

    public MessageEntity url(String url) {
        this.url = url;
        return this;
    }

    public MessageEntity user(User user) {
        this.user = user;
        return this;
    }

    public MessageEntity language(String language) {
        this.language = language;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageEntity that = (MessageEntity) o;
        return type == that.type &&
                Objects.equals(offset, that.offset) &&
                Objects.equals(length, that.length) &&
                Objects.equals(url, that.url) &&
                Objects.equals(user, that.user) &&
                Objects.equals(language, that.language);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, offset, length, url, user, language);
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
