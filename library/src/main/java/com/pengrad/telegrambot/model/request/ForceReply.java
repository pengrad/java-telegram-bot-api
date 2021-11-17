package com.pengrad.telegrambot.model.request;

import java.io.Serializable;

/**
 * stas
 * 8/4/15.
 */
public class ForceReply extends Keyboard implements Serializable {
    private final static long serialVersionUID = 0L;

    private final boolean force_reply = true;
    private String input_field_placeholder;
    private boolean selective = false;

    public ForceReply() {
        this(false);
    }

    public ForceReply(boolean selective) {
        this.selective = selective;
    }

    public ForceReply inputFieldPlaceholder(String inputFieldPlaceholder) {
        this.input_field_placeholder = inputFieldPlaceholder;
        return this;
    }

    public ForceReply selective(boolean selective) {
        this.selective = selective;
        return this;
    }
}
