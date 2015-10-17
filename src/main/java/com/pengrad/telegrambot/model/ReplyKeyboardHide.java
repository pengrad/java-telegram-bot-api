package com.pengrad.telegrambot.model;

/**
 * stas 8/4/15.
 */
public class ReplyKeyboardHide extends Keyboard {

	private final boolean hideKeyboard = true;
	private final boolean selective;

	public ReplyKeyboardHide() {
		this(false);
	}

	public ReplyKeyboardHide(boolean selective) {
		this.selective = selective;
	}

	public boolean isHideKeyboard() {
		return hideKeyboard;
	}

	public boolean isSelective() {
		return selective;
	}
}
