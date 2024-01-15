package com.pengrad.telegrambot.model.chat;

import java.io.Serializable;
import java.util.Objects;

public class ChatShared implements Serializable {
    private final static long serialVersionUID = 0L;

    private Integer request_id;
    private Long chat_id;

    public Integer requestId() {
        return request_id;
    }

    public Long chatId() {
        return chat_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ChatShared that = (ChatShared) o;

        return Objects.equals(request_id, that.request_id) &&
                Objects.equals(chat_id, that.chat_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(request_id,
            chat_id);
    }

    @Override
    public String toString() {
        return "ChatShared{" +
                "request_id='" + request_id + '\'' +
                ", chat_id='" + chat_id + '\'' +
                '}';
    }
}
