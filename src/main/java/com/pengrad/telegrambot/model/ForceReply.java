package com.pengrad.telegrambot.model;

/**
 * stas
 * 8/4/15.
 */
public class ForceReply {

    public final boolean force_reply = true;
    public final boolean selective;

    public ForceReply() {
        this(false);
    }

    public ForceReply(boolean selective) {
        this.selective = selective;
    }
}
