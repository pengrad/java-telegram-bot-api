package com.pengrad.telegrambot.model;

/**
 * stas 8/4/15.
 */
public class ForceReply extends Keyboard {

	private final boolean force_reply = true;
	private final boolean selective;

	public ForceReply() {
		this(false);
	}

	public ForceReply(boolean selective) {
		this.selective = selective;
	}

	public boolean isForceReply() {
		return force_reply;
	}

	public boolean isSelective() {
		return selective;
	}
}
