package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.response.GetAvailableGiftsResponse;

public class GetAvailableGifts extends BaseRequest<GetAvailableGifts, GetAvailableGiftsResponse> {
    public GetAvailableGifts(Object chatId) {
        super(GetAvailableGiftsResponse.class);
        add("chat_id", chatId);
    }
}
