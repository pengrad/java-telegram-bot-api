package com.pengrad.telegrambot.model.chatboost.source;

import java.io.Serializable;
import java.util.Objects;


public class ChatBoostSourceGiftCode extends ChatBoostSource implements Serializable {
    private final static long serialVersionUID = 0L;

    public final static String CHAT_BOOST_TYPE = "gift_code";

    @Override
    public int hashCode() {
        return Objects.hash(source, user);
    }

    @Override
    public String toString() {
        return "ChatBoostSourceGiftCode{" +
                "source='" + source + "'," +
                "user='" + user + "'" +
                '}';
    }

}
