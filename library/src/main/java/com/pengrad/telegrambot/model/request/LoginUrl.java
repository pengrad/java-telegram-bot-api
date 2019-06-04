package com.pengrad.telegrambot.model.request;

import java.io.Serializable;

/**
 * Stas Parshin
 * 04 June 2019
 */
public class LoginUrl implements Serializable {
    private final static long serialVersionUID = 0L;

    private String url;
    private String forward_text;
    private String bot_username;
    private Boolean request_write_access;

    public LoginUrl(String url) {
        this.url = url;
    }

    public LoginUrl forwardText(String forwardText) {
        forward_text = forwardText;
        return this;
    }

    public LoginUrl botUsername(String botUsername) {
        bot_username = botUsername;
        return this;
    }

    public LoginUrl requestWriteAccess(boolean requestWriteAccess) {
        request_write_access = requestWriteAccess;
        return this;
    }
}
