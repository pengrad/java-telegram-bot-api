package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.response.BaseResponse;


public class RefundStarPayment extends BaseRequest<RefundStarPayment, BaseResponse> {

    public RefundStarPayment(Long userId, String telegramPaymentChargeId) {
        super(BaseResponse.class);
        add("user_id", userId).add("telegram_payment_charge_id", telegramPaymentChargeId);
    }

}
