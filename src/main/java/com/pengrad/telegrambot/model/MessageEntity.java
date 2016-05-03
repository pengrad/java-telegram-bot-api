package com.pengrad.telegrambot.model;

/**
 * stas
 * 5/3/16.
 */
public class MessageEntity {

    private String type;
    private Integer offset;
    private Integer length;
    private String url;

    public String type() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MessageEntity that = (MessageEntity) o;

        if (!type.equals(that.type)) return false;
        if (!offset.equals(that.offset)) return false;
        if (!length.equals(that.length)) return false;
        return url != null ? url.equals(that.url) : that.url == null;

    }

    @Override
    public int hashCode() {
        int result = type.hashCode();
        result = 31 * result + offset.hashCode();
        result = 31 * result + length.hashCode();
        result = 31 * result + (url != null ? url.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "MessageEntity{" +
                "type='" + type + '\'' +
                ", offset=" + offset +
                ", length=" + length +
                ", url='" + url + '\'' +
                '}';
    }
}
