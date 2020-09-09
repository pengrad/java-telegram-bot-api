package com.pengrad.telegrambot.model.request;

import java.io.Serializable;
import java.util.Objects;

/**
 * Stas Parshin
 * 06 May 2016
 */
public class InlineKeyboardButton implements Serializable {
    private final static long serialVersionUID = 0L;

    private String text;
    private String url;
    private LoginUrl login_url;
    private String callback_data;
    private String switch_inline_query;
    private String switch_inline_query_current_chat;
    private CallbackGame callback_game;
    private Boolean pay;

    //todo can use only one optional field, make different constructors or static methods

    public InlineKeyboardButton(String text) {
        this.text = text;
    }

    public InlineKeyboardButton url(String url) {
        this.url = url;
        return this;
    }

    public InlineKeyboardButton loginUrl(LoginUrl loginUrl) {
        login_url = loginUrl;
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
        callback_game = new CallbackGame();
        return this;
    }

    public InlineKeyboardButton pay() {
        this.pay = true;
        return this;
    }

    public String text() {
        return text;
    }

    public String url() {
        return url;
    }

    public String callbackData() {
        return callback_data;
    }

    public String switchInlineQuery() {
        return switch_inline_query;
    }

    public String switchInlineQueryCurrentChat() {
        return switch_inline_query_current_chat;
    }

    public CallbackGame callbackGame() {
        return callback_game;
    }

    public boolean isPay() {
        return pay != null ? pay : false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InlineKeyboardButton that = (InlineKeyboardButton) o;

        if (!Objects.equals(text, that.text)) return false;
        if (!Objects.equals(url, that.url)) return false;
        if (!Objects.equals(login_url, that.login_url)) return false;
        if (!Objects.equals(callback_data, that.callback_data)) return false;
        if (!Objects.equals(switch_inline_query, that.switch_inline_query))
            return false;
        if (!Objects.equals(switch_inline_query_current_chat, that.switch_inline_query_current_chat))
            return false;
        if (!Objects.equals(callback_game, that.callback_game)) return false;
        return Objects.equals(pay, that.pay);
    }

    @Override
    public int hashCode() {
        int result = text != null ? text.hashCode() : 0;
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (login_url != null ? login_url.hashCode() : 0);
        result = 31 * result + (callback_data != null ? callback_data.hashCode() : 0);
        result = 31 * result + (switch_inline_query != null ? switch_inline_query.hashCode() : 0);
        result = 31 * result + (switch_inline_query_current_chat != null ? switch_inline_query_current_chat.hashCode() : 0);
        result = 31 * result + (callback_game != null ? callback_game.hashCode() : 0);
        result = 31 * result + (pay != null ? pay.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "InlineKeyboardButton{" +
                "text='" + text + '\'' +
                ", url='" + url + '\'' +
                ", login_url=" + login_url +
                ", callback_data='" + callback_data + '\'' +
                ", switch_inline_query='" + switch_inline_query + '\'' +
                ", switch_inline_query_current_chat='" + switch_inline_query_current_chat + '\'' +
                ", callback_game=" + callback_game +
                ", pay=" + pay +
                '}';
    }
}
