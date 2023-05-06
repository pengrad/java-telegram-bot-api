package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.impl.TelegramBotClient;

/**
 * stas
 * 5/1/16.
 */
public class SendContact extends AbstractSendRequest<SendContact> {

    public SendContact(TelegramBotClient api, Object chatId, String phoneNumber, String firstName) {
        super(api, chatId);
        add("phone_number", phoneNumber);
        add("first_name", firstName);
    }

    public SendContact lastName(String lastName) {
        return add("last_name", lastName);
    }

    public SendContact vcard(String vcard) {
        return add("vcard", vcard);
    }
}
