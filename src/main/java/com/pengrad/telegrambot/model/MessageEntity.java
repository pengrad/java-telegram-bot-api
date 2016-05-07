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

        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (offset != null ? !offset.equals(that.offset) : that.offset != null) return false;
        if (length != null ? !length.equals(that.length) : that.length != null) return false;
        return url != null ? url.equals(that.url) : that.url == null;

    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + (offset != null ? offset.hashCode() : 0);
        result = 31 * result + (length != null ? length.hashCode() : 0);
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
