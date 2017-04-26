package com.pengrad.telegrambot.model.request;

import java.io.Serializable;

/**
 * Stas Parshin
 * 03 October 2016
 */
public class InlineQueryResultGame extends InlineQueryResult<InlineQueryResultGame> implements Serializable {
    private final static long serialVersionUID = 0L;

    private String game_short_name;

    public InlineQueryResultGame(String id, String gameShortName) {
        super("game", id);
        game_short_name = gameShortName;
    }
}
