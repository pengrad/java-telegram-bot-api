package com.pengrad.telegrambot.model.request;

import com.pengrad.telegrambot.model.request.Keyboard;

public class InlineKeyboardMarkup extends Keyboard {

	private InlineKeyboardButton[][] inline_keyboard;

	public InlineKeyboardMarkup( InlineKeyboardButton[] ... keyboards ) {

		this.inline_keyboard = keyboards;
	}

	public InlineKeyboardButton[][] getInline_keyboard() {

		return inline_keyboard;
	}

	public void setInline_keyboard(
			InlineKeyboardButton[][] inline_keyboard ) {

		this.inline_keyboard = inline_keyboard;
	}

}
