package com.pengrad.telegrambot.model.request;

import java.io.Serializable;

/**
 * stas
 * 8/4/15.
 */
public class ForceReply extends Keyboard implements Serializable {
    private final static long serialVersionUID = 0L;

    private final boolean force_reply = true;
    private final boolean selective;

    public ForceReply() {
        this(false);
    }

    public ForceReply(boolean selective) {
        this.selective = selective;
    }
}
