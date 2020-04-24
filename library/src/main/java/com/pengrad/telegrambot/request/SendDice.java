package com.pengrad.telegrambot.request;

/**
 * Stas Parshin
 * 31 March 2020
 */
public class SendDice extends AbstractSendRequest<SendDice> {

    public SendDice(Object chatId) {
        super(chatId);
    }

    public SendDice darts() {
        return emoji("🎯");
    }

    public SendDice emoji(String emoji) {
        return add("emoji", emoji);
    }
}
