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
        text_mention, underline, strikethrough, spoiler, custom_emoji, blockquote, expandable_blockquote
    }

    private Type type;
    private Integer offset;
    private Integer length;
    private String url;
    private User user;
    private String language;
    private String custom_emoji_id;

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

    public String customEmojiId() {
        return custom_emoji_id;
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

    public MessageEntity customEmojiId(String custom_emoji_id) {
        this.custom_emoji_id = custom_emoji_id;
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
                Objects.equals(language, that.language) &&
                Objects.equals(custom_emoji_id, that.custom_emoji_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, offset, length, url, user, language, custom_emoji_id);
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
                ", custom_emoji_id='" + custom_emoji_id + '\'' +
                '}';
    }
}
