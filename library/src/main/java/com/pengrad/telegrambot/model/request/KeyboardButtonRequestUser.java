package com.pengrad.telegrambot.model.request;

import java.io.Serializable;

/**
 * @deprecated Use KeyboardButtonRequestUsers instead
 */
@Deprecated
public class KeyboardButtonRequestUser implements Serializable {
    private final static long serialVersionUID = 0L;

    private Integer request_id;
    private Boolean user_is_bot;
    private Boolean user_is_premium;

    public KeyboardButtonRequestUser(Integer requestId) {
        this.request_id = requestId;
    }

    public KeyboardButtonRequestUser userIsBot(Boolean userIsBot) {
        this.user_is_bot = userIsBot;
        return this;
    }

    public KeyboardButtonRequestUser userIsPremium(Boolean userIsPremium) {
        this.user_is_premium = userIsPremium;
        return this;
    }

}
