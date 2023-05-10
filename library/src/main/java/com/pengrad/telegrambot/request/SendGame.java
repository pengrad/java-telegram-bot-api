package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.impl.TelegramBotClient;

/**
 * Stas Parshin
 * 03 October 2016
 */
public class SendGame extends AbstractSendRequest<SendGame> {

    public SendGame(TelegramBotClient api, Object chatId, String gameShortName) {
        super(api, chatId);
        add("game_short_name", gameShortName);
    }

}
