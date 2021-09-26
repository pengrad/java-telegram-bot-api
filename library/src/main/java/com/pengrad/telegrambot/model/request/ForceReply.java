package com.pengrad.telegrambot.model.request;

import java.io.Serializable;

/**
 * stas
 * 8/4/15.
 */
public class ForceReply extends Keyboard implements Serializable {
    private final static long serialVersionUID = 0L;

    private final boolean force_reply = true;
    private String input_field_placeholder = "";
    private boolean selective = false;

    public ForceReply() {
        this(false);
    }

    public ForceReply(boolean selective) {
        this.selective = selective;
    }

    // API v5.3 - added field input_field_placeholder
    public ForceReply(boolean selective, String input_field_placeholder) {
        this.selective = selective;
        this.input_field_placeholder = input_field_placeholder;
    }
    public ForceReply(String input_field_placeholder) {
        this.input_field_placeholder = input_field_placeholder;
    }
}
