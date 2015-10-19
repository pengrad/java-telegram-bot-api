package com.pengrad.telegrambot.response;

import com.pengrad.telegrambot.model.User;

/**
 * stas 8/4/15.
 */
public class GetMeResponse {
	private final boolean ok;
	private final User result;

	public GetMeResponse(boolean ok, User result) {
		this.ok = ok;
		this.result = result;
	}

	public boolean isOk() {
		return ok;
	}

	public User getResult() {
		return result;
	}
}
