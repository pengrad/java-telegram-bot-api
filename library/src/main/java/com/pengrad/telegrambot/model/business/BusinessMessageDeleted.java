package com.pengrad.telegrambot.model.business;

import com.pengrad.telegrambot.model.Chat;

import java.util.Arrays;
import java.util.Objects;

public class BusinessMessageDeleted {

    private String business_connection_id;
    private Chat chat;
    private Integer[] message_ids;

    public String businessConnectionId() {
        return business_connection_id;
    }

    public Chat chat() {
        return chat;
    }

    public Integer[] messageIds() {
        return message_ids;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BusinessMessageDeleted that = (BusinessMessageDeleted) o;
        return Objects.equals(business_connection_id, that.business_connection_id) && Objects.equals(chat, that.chat) && Objects.deepEquals(message_ids, that.message_ids);
    }

    @Override
    public int hashCode() {
        return Objects.hash(business_connection_id, chat, Arrays.hashCode(message_ids));
    }

    @Override
    public String toString() {
        return "BusinessMessageDeleted{" +
                "business_connection_id='" + business_connection_id + '\'' +
                ", chat=" + chat +
                ", message_ids=" + Arrays.toString(message_ids) +
                '}';
    }
}
