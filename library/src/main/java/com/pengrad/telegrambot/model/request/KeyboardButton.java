package com.pengrad.telegrambot.model.request;

import java.io.Serializable;

import com.pengrad.telegrambot.model.WebAppInfo;

/**
 * Stas Parshin
 * 06 May 2016
 */
public class KeyboardButton implements Serializable {
    private final static long serialVersionUID = 0L;

    private String text;
    private boolean request_contact;
    private boolean request_location;
    private KeyboardButtonPollType request_poll;
    private KeyboardButtonRequestUsers request_users;
    private KeyboardButtonRequestUser request_user; // @deprecated
    private KeyboardButtonRequestChat request_chat;
    private WebAppInfo web_app;

    public KeyboardButton(String text) {
        this.text = text;
    }

    public KeyboardButton requestLocation(boolean requestLocation) {
        request_location = requestLocation;
        return this;
    }

    public KeyboardButton requestContact(boolean requestContact) {
        request_contact = requestContact;
        return this;
    }

    public KeyboardButton requestPoll(KeyboardButtonPollType poll) {
        this.request_poll = poll;
        return this;
    }

    /**
     * @deprecated Use requestUsers instead
     */
    @Deprecated
    public KeyboardButton requestUser(KeyboardButtonRequestUser user) {
        this.request_user = user;
        return this;
    }

    public KeyboardButton requestUsers(KeyboardButtonRequestUsers users) {
        this.request_users = users;
        return this;
    }

    public KeyboardButton requestChat(KeyboardButtonRequestChat chat) {
        this.request_chat = chat;
        return this;
    }

    public KeyboardButton webAppInfo(WebAppInfo webApp) {
        this.web_app = webApp;
        return this;
    }
}
