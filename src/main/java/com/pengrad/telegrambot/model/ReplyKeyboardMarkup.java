package com.pengrad.telegrambot.model;

/**
 * stas 8/4/15.
 */
public class ReplyKeyboardMarkup extends Keyboard {

	private final String[][] keyboard;
	private final boolean resize_keyboard;
	private final boolean one_time_keyboard;
	private final boolean selective;

	public ReplyKeyboardMarkup(String[]... keyboard) {
		this(keyboard, false, false, false);
	}

	public ReplyKeyboardMarkup(String[][] keyboard, boolean resize_keyboard, boolean one_time_keyboard,
			boolean selective) {
		this.keyboard = keyboard;
		this.resize_keyboard = resize_keyboard;
		this.one_time_keyboard = one_time_keyboard;
		this.selective = selective;
	}

	public String[][] getKeyboard() {
		return keyboard;
	}

	public boolean isResizeKeyboard() {
		return resize_keyboard;
	}

	public boolean isOneTimeKeyboard() {
		return one_time_keyboard;
	}

	public boolean isSelective() {
		return selective;
	}
}
