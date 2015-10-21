package com.pengrad.telegrambot.response;

import com.pengrad.telegrambot.model.UserProfilePhotos;

/**
 * stas
 * 8/11/15.
 */
public class GetUserProfilePhotosResponse {

    public final boolean ok;
    public final UserProfilePhotos result;

    public GetUserProfilePhotosResponse(boolean ok, UserProfilePhotos result) {
        this.ok = ok;
        this.result = result;
    }
}
