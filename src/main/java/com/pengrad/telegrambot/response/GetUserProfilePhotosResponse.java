package com.pengrad.telegrambot.response;

import com.pengrad.telegrambot.model.UserProfilePhotos;

/**
 * stas
 * 8/11/15.
 */
public class GetUserProfilePhotosResponse {

    private boolean ok;
    private UserProfilePhotos result;

    GetUserProfilePhotosResponse() {
    }

    public boolean isOk() {
        return ok;
    }

    public UserProfilePhotos photos() {
        return result;
    }

    @Override
    public String toString() {
        return "GetUserProfilePhotosResponse{" +
                "ok=" + ok +
                ", result=" + result +
                '}';
    }
}
