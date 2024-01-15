package com.pengrad.telegrambot.model.chatboost;

import com.pengrad.telegrambot.model.Chat;
import com.pengrad.telegrambot.model.chatboost.source.ChatBoostSource;

import java.util.Objects;

public class ChatBoostRemoved {

    private Chat chat;
    private String boost_id;
    private Integer remove_date;
    private ChatBoostSource source;

    public Chat chat() {
        return chat;
    }

    public String boostId() {
        return boost_id;
    }

    public Integer removeDate() {
        return remove_date;
    }

    public ChatBoostSource source() {
        return source;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChatBoostRemoved that = (ChatBoostRemoved) o;
        return Objects.equals(chat, that.chat)
                && Objects.equals(boost_id, that.boost_id)
                && Objects.equals(remove_date, that.remove_date)
                && Objects.equals(source, that.source);
    }

    @Override
    public int hashCode() {
        return boost_id != null ? boost_id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "ChatBoostRemoved{" +
            "chat=" + chat +
            ", boost_id='" + boost_id + '\'' +
            ", remove_date=" + remove_date +
            ", source=" + source +
            '}';
    }
}
