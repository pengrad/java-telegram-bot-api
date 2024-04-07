package com.pengrad.telegrambot.model.request;

import java.io.Serializable;

public class KeyboardButtonRequestUsers implements Serializable {
    private final static long serialVersionUID = 0L;

    private Integer request_id;
    private Boolean user_is_bot;
    private Boolean user_is_premium;
    private Integer max_quantity;
    private Boolean request_name;
    private Boolean request_username;
    private Boolean request_photo;

    public KeyboardButtonRequestUsers(Integer requestId) {
        this.request_id = requestId;
    }

    public KeyboardButtonRequestUsers userIsBot(Boolean userIsBot) {
        this.user_is_bot = userIsBot;
        return this;
    }

    public KeyboardButtonRequestUsers userIsPremium(Boolean userIsPremium) {
        this.user_is_premium = userIsPremium;
        return this;
    }

    public KeyboardButtonRequestUsers maxQuantity(Integer maxQuantity) {
        this.max_quantity = maxQuantity;
        return this;
    }

    public KeyboardButtonRequestUsers requestName(Boolean requestName) {
        this.request_name = requestName;
        return this;
    }

    public KeyboardButtonRequestUsers requestUsername(Boolean requestUsername) {
        this.request_username = requestUsername;
        return this;
    }

    public KeyboardButtonRequestUsers requestPhoto(Boolean requestPhoto) {
        this.request_photo = requestPhoto;
        return this;
    }

}
