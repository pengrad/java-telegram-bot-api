package com.pengrad.telegrambot.model;

/**
 * Stas Parshin
 * 07 May 2016
 */
public class CallbackQuery {

    private String id;
    private User from;
    private Message message;
    private String inline_message_id;
    private String data;

    public String id() {
        return id;
    }

    public User from() {
        return from;
    }

    public Message message() {
        return message;
    }

    public String inlineMessageId() {
        return inline_message_id;
    }

    public String data() {
        return data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CallbackQuery that = (CallbackQuery) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (from != null ? !from.equals(that.from) : that.from != null) return false;
        if (message != null ? !message.equals(that.message) : that.message != null) return false;
        if (inline_message_id != null ? !inline_message_id.equals(that.inline_message_id) : that.inline_message_id != null)
            return false;
        return data != null ? data.equals(that.data) : that.data == null;

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "CallbackQuery{" +
                "id='" + id + '\'' +
                ", from=" + from +
                ", message=" + message +
                ", inline_message_id='" + inline_message_id + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
