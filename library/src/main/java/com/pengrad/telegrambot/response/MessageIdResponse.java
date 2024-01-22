package com.pengrad.telegrambot.response;

import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.MessageId;

/**
 * Stas Parshin
 * 06 November 2020
 */
public class MessageIdResponse extends BaseResponse {

    private MessageId result;

    public MessageId result() {
        return result;
    }

    public Integer messageId() {
        return result.messageId();
    }

    @Override
    public String toString() {
        return "MessageIdResponse{" +
                "result=" + result +
                '}';
    }
}
