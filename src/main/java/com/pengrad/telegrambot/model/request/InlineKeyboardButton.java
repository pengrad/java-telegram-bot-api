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
}
