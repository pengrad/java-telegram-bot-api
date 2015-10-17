package com.pengrad.telegrambot.model;

/**
 * stas 8/4/15.
 */
public class ReplyKeyboardMarkup extends Keyboard {

	private final String[][] keyboard;
	private final boolean resizeKeyboard;
	private final boolean oneTimeKeyboard;
	private final boolean selective;

	public ReplyKeyboardMarkup(String[]... keyboard) {
		this(keyboard, false, false, false);
	}

	public ReplyKeyboardMarkup(String[][] keyboard, boolean resize_keyboard, boolean one_time_keyboard,
			boolean selective) {
		this.keyboard = keyboard;
		this.resizeKeyboard = resize_keyboard;
		this.oneTimeKeyboard = one_time_keyboard;
		this.selective = selective;
	}

	public String[][] getKeyboard() {
		return keyboard;
	}

	public boolean isResizeKeyboard() {
		return resizeKeyboard;
	}

	public boolean isOneTimeKeyboard() {
		return oneTimeKeyboard;
	}

	public boolean isSelective() {
		return selective;
	}
}
