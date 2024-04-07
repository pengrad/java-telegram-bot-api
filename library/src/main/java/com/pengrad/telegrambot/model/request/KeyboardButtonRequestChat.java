package com.pengrad.telegrambot.model.request;

import java.io.Serializable;

import com.pengrad.telegrambot.model.ChatAdministratorRights;

public class KeyboardButtonRequestChat implements Serializable {
    private final static long serialVersionUID = 0L;

    private Integer request_id;
    private Boolean chat_is_channel;
    private Boolean chat_is_forum;
    private Boolean chat_has_username;
    private Boolean chat_is_created;
    private ChatAdministratorRights user_administrator_rights;
    private ChatAdministratorRights bot_administrator_rights;
    private Boolean bot_is_member;
    private Boolean request_title;
    private Boolean request_username;
    private Boolean request_photo;

    public KeyboardButtonRequestChat(Integer requestId, Boolean chatIsChannel) {
        this.request_id = requestId;
        this.chat_is_channel = chatIsChannel;
    }

    public KeyboardButtonRequestChat chatIsForum(Boolean chatIsForum) {
        this.chat_is_forum = chatIsForum;
        return this;
    }

    public KeyboardButtonRequestChat chatHasUsername(Boolean chatHasUsername) {
        this.chat_has_username = chatHasUsername;
        return this;
    }

    public KeyboardButtonRequestChat chatIsCreated(Boolean chatIsCreated) {
        this.chat_is_created = chatIsCreated;
        return this;
    }

    public KeyboardButtonRequestChat userAdministratorRights(ChatAdministratorRights userAdministratorRights) {
        this.user_administrator_rights = userAdministratorRights;
        return this;
    }

    public KeyboardButtonRequestChat botAdministratorRights(ChatAdministratorRights botAdministratorRights) {
        this.bot_administrator_rights = botAdministratorRights;
        return this;
    }

    public KeyboardButtonRequestChat botIsMember(Boolean botIsMember) {
        this.bot_is_member = botIsMember;
        return this;
    }

    public KeyboardButtonRequestChat requestTitle(Boolean requestTitle) {
        this.request_title = requestTitle;
        return this;
    }

    public KeyboardButtonRequestChat requestUsername(Boolean requestUsername) {
        this.request_username = requestUsername;
        return this;
    }

    public KeyboardButtonRequestChat requestPhoto(Boolean requestPhoto) {
        this.request_photo = requestPhoto;
        return this;
    }

}
