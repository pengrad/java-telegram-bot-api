package com.pengrad.telegrambot.request;

/**
 * Stas Parshin
 * 31 March 2020
 */
public class SendDice extends AbstractSendRequest<SendDice> {

    public SendDice(Object chatId) {
        super(chatId);
    }

    public SendDice emoji(String emoji) {
        return add("emoji", emoji);
    }

    public SendDice darts() {
        return emoji("🎯");
    }

    public SendDice basketball() {
        return emoji("🏀");
    }

    public SendDice football() {
        return emoji("⚽");
    }

    public SendDice slotMachine() {
        return emoji("🎰");
    }

    public SendDice bowling() {
        return emoji("🎳");
    }
}
