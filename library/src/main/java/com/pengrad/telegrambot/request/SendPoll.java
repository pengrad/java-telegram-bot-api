package com.pengrad.telegrambot.request;

/**
 * Stas Parshin
 * 17 April 2019
 */
public class SendPoll extends AbstractSendRequest<SendPoll> {

    public SendPoll(Object chatId, String question, String... options) {
        super(chatId);
        add("question", question);
        add("options", serialize(options));
    }
}
