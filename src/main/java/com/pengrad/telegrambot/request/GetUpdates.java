package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.impl.TelegramApi;
import com.pengrad.telegrambot.response.GetUpdatesResponse;

/**
 * stas
 * 5/2/16.
 */
public class GetUpdates extends BaseRequest<GetUpdates, GetUpdatesResponse> {

    public GetUpdates(TelegramApi api) {
        super(api, GetUpdatesResponse.class);
    }

    public GetUpdates offset(int offset) {
        return add("offset", offset);
    }

    public GetUpdates limit(int limit) {
        return add("limit", limit);
    }

    public GetUpdates timeout(int timeout) {
        return add("timeout", timeout);
    }
}
