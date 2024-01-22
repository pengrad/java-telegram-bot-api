package com.pengrad.telegrambot.model.request;

import com.pengrad.telegrambot.model.MessageEntity;

import java.io.Serializable;

public class ReplyParameters implements Serializable {

    private final static long serialVersionUID = 0L;

    private Integer message_id;
    private Object chat_id;
    private Boolean allow_sending_without_reply;
    private String quote;
    private String quote_parse_mode;
    private MessageEntity[] quote_entities;
    private Integer quote_position;

    public ReplyParameters(Integer messageId) {
        this.message_id = messageId;
    }

    public ReplyParameters(Integer messageId, Object chatId) {
        this.message_id = messageId;
        this.chat_id = chatId;
    }

    public ReplyParameters allowSendingWithoutReply(Boolean allowSendingWithoutReply) {
        this.allow_sending_without_reply = allowSendingWithoutReply;
        return this;
    }

    public ReplyParameters quote(String quote) {
        this.quote = quote;
        return this;
    }

    public ReplyParameters quoteParseMode(ParseMode parseMode) {
        this.quote_parse_mode = parseMode.name();
        return this;
    }

    public ReplyParameters quoteEntities(MessageEntity[] quoteEntities) {
        this.quote_entities = quoteEntities;
        return this;
    }

    public ReplyParameters quotePosition(Integer quotePosition) {
        this.quote_position = quotePosition;
        return this;
    }
}
