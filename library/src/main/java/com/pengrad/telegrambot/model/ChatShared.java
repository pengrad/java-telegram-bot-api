package com.pengrad.telegrambot.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

public class ChatShared implements Serializable {
    private final static long serialVersionUID = 0L;

    private Integer request_id;
    private Long chat_id;
    private String title;
    private String username;
    private PhotoSize[] photo;

    public Integer requestId() {
        return request_id;
    }

    public Long chatId() {
        return chat_id;
    }

    public String title() {
        return title;
    }

    public String username() {
        return username;
    }

    public PhotoSize[] photo() {
        return photo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ChatShared that = (ChatShared) o;

        return Objects.equals(request_id, that.request_id)
            && Objects.equals(chat_id, that.chat_id)
            && Objects.equals(title, that.title)
            && Objects.equals(username, that.username)
            && Arrays.equals(photo, that.photo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(request_id,
            chat_id,
            title,
            username,
            Arrays.hashCode(photo));
    }

    @Override
    public String toString() {
        return "ChatShared{" +
            "request_id=" + request_id +
            ", chat_id=" + chat_id +
            ", title='" + title + '\'' +
            ", username='" + username + '\'' +
            ", photo=" + Arrays.toString(photo) +
            '}';
    }
}
