package com.pengrad.telegrambot.model.chatboost.source;

import java.io.Serializable;
import java.util.Objects;


public class ChatBoostSourcePremium extends ChatBoostSource implements Serializable {
    private final static long serialVersionUID = 0L;

    public final static String CHAT_BOOST_TYPE = "premium";

    @Override
    public int hashCode() {
        return Objects.hash(source, user);
    }

    @Override
    public String toString() {
        return "ChatBoostSourcePremium{" +
                "source='" + source + "'," +
                "user='" + user + "'" +
                '}';
    }
}
