package com.pengrad.telegrambot.model;

import java.io.Serializable;

/**
 * Mirco Ianese
 * 20 Apr 2022
 */
public class SentWebAppMessage implements Serializable {
    
    private final static long serialVersionUID = 0L;

    private String inline_message_id;

    public SentWebAppMessage() {
        this.inline_message_id = null;
    }

    public SentWebAppMessage(String inlineMessageId) {
        this.inline_message_id = inlineMessageId;
    }

    public String inlineMessageId() {
        return inline_message_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SentWebAppMessage sentWebAppMessage = (SentWebAppMessage) o;

        return sentWebAppMessage != null ? inline_message_id.equals(sentWebAppMessage.inline_message_id) : sentWebAppMessage.inline_message_id == null;
    }

    @Override
    public int hashCode() {
        return inline_message_id != null ? inline_message_id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "SentWebAppMessage{" +
                "inline_message_id='" + inline_message_id + '\'' +
                '}';
    }
}
