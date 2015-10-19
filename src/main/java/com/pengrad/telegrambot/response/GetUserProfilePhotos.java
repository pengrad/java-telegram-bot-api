package com.pengrad.telegrambot.response;

import com.pengrad.telegrambot.model.UserProfilePhotos;

/**
 * stas 8/11/15.
 */
public class GetUserProfilePhotos {

	private final boolean ok;
	private final UserProfilePhotos result;

	public GetUserProfilePhotos(boolean ok, UserProfilePhotos result) {
		this.ok = ok;
		this.result = result;
	}

	public boolean isOk() {
		return ok;
	}

	public UserProfilePhotos getResult() {
		return result;
	}
}
