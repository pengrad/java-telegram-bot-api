package com.pengrad.telegrambot.model.request;

import java.io.Serializable;

/**
 * Stas Parshin
 * 06 May 2016
 */
public class InlineKeyboardButton implements Serializable {
    private final static long serialVersionUID = 0L;

    private String text;
    private String url;
    private String callback_data;
    private String switch_inline_query;
    private String switch_inline_query_current_chat;
    private String callback_game;
    private Boolean pay;

    //todo can use only one optional field, make different constructors or static methods

    public InlineKeyboardButton(String text) {
        this.text = text;
    }

    public InlineKeyboardButton url(String url) {
        this.url = url;
        return this;
    }

    public InlineKeyboardButton callbackData(String callbackData) {
        callback_data = callbackData;
        return this;
    }

    public InlineKeyboardButton switchInlineQuery(String switchInlineQuery) {
        switch_inline_query = switchInlineQuery;
        return this;
    }

    public InlineKeyboardButton switchInlineQueryCurrentChat(String switchInlineQueryCurrentChat) {
        switch_inline_query_current_chat = switchInlineQueryCurrentChat;
        return this;
    }

    public InlineKeyboardButton callbackGame(String callbackGame) {
        callback_game = callbackGame;
        return this;
    }

    public InlineKeyboardButton pay() {
        this.pay = true;
        return this;
    }
}
