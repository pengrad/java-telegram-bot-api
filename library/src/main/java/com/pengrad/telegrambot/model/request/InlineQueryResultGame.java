package com.pengrad.telegrambot.model.request;

/**
 * Stas Parshin
 * 03 October 2016
 */
public class InlineQueryResultGame extends InlineQueryResult<InlineQueryResultGame> {

    private String game_short_name;

    public InlineQueryResultGame(String id, String gameShortName) {
        super("game", id);
        game_short_name = gameShortName;
    }
}
