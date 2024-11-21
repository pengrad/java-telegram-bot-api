package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.response.BaseResponse;

public class SendGift extends AbstractSendRequest<SendGift> {
    public SendGift(Long userId, String giftId) {
        super(BaseResponse.class);
        add("user_id", userId);
        add("gift_id", giftId);
    }
}

