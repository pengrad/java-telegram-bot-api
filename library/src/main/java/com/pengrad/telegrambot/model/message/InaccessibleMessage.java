package com.pengrad.telegrambot.model.message;

public class InaccessibleMessage extends MaybeInaccessibleMessage {

    public static final Integer INACCESSIBLE_MESSAGE_DATE = 0;

    @Override
    public String toString() {
        return "InaccessibleMessage{" +
            "chat=" + chat +
            ", message_id=" + message_id +
            ", date=" + date +
            '}';
    }
}
