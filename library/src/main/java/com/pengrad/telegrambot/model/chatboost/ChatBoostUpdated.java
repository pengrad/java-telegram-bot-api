package com.pengrad.telegrambot.model.chatboost;

import com.pengrad.telegrambot.model.Chat;

import java.util.Objects;

public class ChatBoostUpdated {

    private Chat chat;
    private ChatBoost boost;

    public Chat chat() {
        return chat;
    }

    public ChatBoost boost() {
        return boost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChatBoostUpdated that = (ChatBoostUpdated) o;
        return Objects.equals(chat, that.chat)
                && Objects.equals(boost, that.boost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(chat, boost);
    }

    @Override
    public String toString() {
        return "ChatBoostUpdated{" +
            "chat=" + chat +
            ", boost=" + boost +
            '}';
    }
}
