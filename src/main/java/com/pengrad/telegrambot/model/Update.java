package com.pengrad.telegrambot.model;

/**
 * stas
 * 8/4/15.
 */
public class Update {

    private Integer update_id;
    private Message message;

    Update() {
    }

    public Integer updateId() {
        return update_id;
    }

    public Message message() {
        return message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Update update = (Update) o;

        if (update_id != null ? !update_id.equals(update.update_id) : update.update_id != null) return false;
        return message != null ? message.equals(update.message) : update.message == null;
    }

    @Override
    public int hashCode() {
        return update_id.hashCode();
    }

    @Override
    public String toString() {
        return "Update{" +
                "update_id=" + update_id +
                ", message=" + message +
                '}';
    }
}
