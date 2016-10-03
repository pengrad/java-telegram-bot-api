package com.pengrad.telegrambot.model.request;

/**
 * Stas Parshin
 * 06 May 2016
 */
public class InlineKeyboardButton {

    private String text;
    private String url;
    private String callback_data;
    private String switch_inline_query;
    private String switch_inline_query_current_chat;
    private String callback_game;

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
}
