package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.model.Poll;

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

    public SendPoll isAnonymous(boolean isAnonymous) {
        return add("is_anonymous", isAnonymous);
    }

    public SendPoll type(String type) {
        return add("type", type);
    }

    public SendPoll type(Poll.Type type) {
        return add("type", type);
    }

    public SendPoll correctOptionId(int correctOptionId) {
        return add("correct_option_id", correctOptionId);
    }

    public SendPoll allowsMultipleAnswers(boolean allowsMultipleAnswers) {
        return add("allows_multiple_answers", allowsMultipleAnswers);
    }

    public SendPoll isClosed(boolean isClosed) {
        return add("is_closed", isClosed);
    }
}
