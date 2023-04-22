package com.pengrad.telegrambot.model.request;

import java.io.Serializable;
import java.util.Objects;

public class SwitchInlineQueryChosenChat implements Serializable {
    private final static long serialVersionUID = 0L;

    private String query;
    private Boolean allow_user_chats;
    private Boolean allow_bot_chats;
    private Boolean allow_group_chats;
    private Boolean allow_channel_chats;

    public SwitchInlineQueryChosenChat query(String query) {
        this.query = query;
        return this;
    }

    public SwitchInlineQueryChosenChat allowUserChats(Boolean allowUserChats) {
        this.allow_user_chats = allowUserChats;
        return this;
    }

    public SwitchInlineQueryChosenChat allowBotChats(Boolean allowBotChats) {
        this.allow_bot_chats = allowBotChats;
        return this;
    }

    public SwitchInlineQueryChosenChat allowGroupChats(Boolean allowGroupChats) {
        this.allow_group_chats = allowGroupChats;
        return this;
    }

    public SwitchInlineQueryChosenChat allowChannelChats(Boolean allowChannelChats) {
        this.allow_channel_chats = allowChannelChats;
        return this;
    }
}
