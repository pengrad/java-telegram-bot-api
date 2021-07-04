package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.response.GetUserProfilePhotosResponse;

/**
 * stas
 * 5/2/16.
 */
public class GetUserProfilePhotos extends BaseRequest<GetUserProfilePhotos, GetUserProfilePhotosResponse> {

    public GetUserProfilePhotos(long userId) {
        super(GetUserProfilePhotosResponse.class);
        add("user_id", userId);
    }

    public GetUserProfilePhotos offset(int offset) {
        return add("offset", offset);
    }

    public GetUserProfilePhotos limit(int limit) {
        return add("limit", limit);
    }
}
