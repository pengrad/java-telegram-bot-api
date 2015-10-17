package com.pengrad.telegrambot.response;

import com.pengrad.telegrambot.model.Message;

/**
 * stas 8/5/15.
 */
public class SendResponse {

	private final boolean ok;
	private final Message result;

	public SendResponse(boolean ok, Message result) {
		this.ok = ok;
		this.result = result;
	}

	public boolean isOk() {
		return ok;
	}

	public Message getResult() {
		return result;
	}
}
