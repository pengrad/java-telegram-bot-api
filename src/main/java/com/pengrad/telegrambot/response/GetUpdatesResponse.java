package com.pengrad.telegrambot.response;

import com.pengrad.telegrambot.model.Update;

import java.util.List;

/**
 * stas 8/11/15.
 */
public class GetUpdatesResponse {

	private final boolean ok;
	private final List<Update> result;

	public GetUpdatesResponse(boolean ok, List<Update> result) {
		this.ok = ok;
		this.result = result;
	}

	public boolean isOk() {
		return ok;
	}

	public List<Update> getResult() {
		return result;
	}
}