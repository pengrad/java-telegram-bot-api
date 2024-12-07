package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.response.BaseResponse;


public class EditUserStarSubscription extends BaseRequest<EditUserStarSubscription, BaseResponse> {

    /**
     *
     * @param userId Identifier of the user whose subscription will be edited
     * @param telegramPaymentChargeId Telegram payment identifier for the subscription
     * @param isCanceled Pass True to cancel extension of the user subscription;
     *                    the subscription must be active up to the end of the current subscription period.
     *                    Pass False to allow the user to re-enable a subscription
     *                    that was previously canceled by the bot.
     */
    public EditUserStarSubscription(Long userId, String telegramPaymentChargeId, boolean isCanceled) {
        super(BaseResponse.class);
        add("user_id", userId).add("telegram_payment_charge_id", telegramPaymentChargeId).add("is_canceled", isCanceled);
    }
}
